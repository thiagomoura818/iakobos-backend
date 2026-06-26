package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VerseRepository extends JpaRepository<Verse, Long>{

}
