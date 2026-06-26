package com.iakobos.iakobos.service;

import com.iakobos.iakobos.dto.CreateVerseNoteDTO;
import com.iakobos.iakobos.dto.UpdateVerseNoteDTO;
import com.iakobos.iakobos.dto.VerseNoteDTO;
import com.iakobos.iakobos.infra.security.AuthenticationService;
import com.iakobos.iakobos.mapper.VerseNoteMapper;
import com.iakobos.iakobos.model.User;
import com.iakobos.iakobos.model.Verse;
import com.iakobos.iakobos.model.VerseNote;
import com.iakobos.iakobos.repository.UserRepository;
import com.iakobos.iakobos.repository.VerseNoteRepository;
import com.iakobos.iakobos.repository.VerseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.security.access.AccessDeniedException;

@RequiredArgsConstructor
@Service
public class VerseNoteService {

    private final VerseNoteRepository verseNoteRepository;
    private final UserRepository userRepository;
    private final VerseRepository verseRepository;
    private final VerseNoteMapper verseNoteMapper;
    private final AuthenticationService authenticationService;

    public VerseNoteDTO insert(CreateVerseNoteDTO dto) {
        User user = authenticationService.getAuthenticatedUser();

        Verse verse = verseRepository.findById(dto.verseId())
                .orElseThrow(() -> new RuntimeException("Versículo não encontrado"));

        VerseNote newNote = VerseNote.builder()
                .user(user)
                .verse(verse)
                .content(dto.content())
                .build();

        verseNoteRepository.save(newNote);

        return verseNoteMapper.toResponse(newNote);
    }

    @Transactional
    public VerseNoteDTO update(UpdateVerseNoteDTO dto) {
        User user = authenticationService.getAuthenticatedUser();

        VerseNote note = verseNoteRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));

        if (!note.getUser().getId().equals(user.getId()))
            throw new AccessDeniedException("Você não pode editar esta nota.");

        note.setContent(dto.content());

        VerseNote updatedNote = verseNoteRepository.save(note);

        return verseNoteMapper.toResponse(updatedNote);
    }

    public VerseNoteDTO getNoteBySpecificVerse(Short bookId, Integer chapter, String verse){
        User user = authenticationService.getAuthenticatedUser();

        return verseNoteRepository.findNote(
                        user.getId(),
                        bookId,
                        chapter,
                        verse)
                .map(verseNoteMapper::toResponse)
                .orElse(null);
    }

    @Transactional
    public void delete(Long noteId) {

        User user = authenticationService.getAuthenticatedUser();

        VerseNote note = verseNoteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));

        if (!note.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Você não pode excluir esta nota.");
        }

        verseNoteRepository.delete(note);
    }
}
