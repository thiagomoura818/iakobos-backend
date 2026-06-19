package com.iakobos.iakobos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exemplo")
public class ExampleController {

    // 1. Liberado para qualquer usuário AUTENTICADO
    // Como nossa regra padrão (anyRequest().authenticated()) já exige autenticação,
    // o @PreAuthorize("isAuthenticated()") aqui é até redundante, mas é ótimo para clareza
    // ou se você tiver rotas que de outra forma seriam permitidas.
    @GetMapping("/livre-para-logados")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> livreParaLogados() {
        return ResponseEntity.ok("Sucesso: Você está autenticado e acessou este recurso.");
    }

    // 2. Restrito apenas para administradores
    // O Spring intercepta e verifica se o JWT possui a authority "ROLE_ADMIN".
    // Se não tiver, o CustomAccessDeniedHandler é acionado e devolve um 403 em JSON.
    @PostMapping("/somente-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> somenteAdmin() {
        return ResponseEntity.ok("Sucesso: Ação administrativa executada com autorização.");
    }

    // 3. Restrito para múltiplos perfis (ex: ADMIN ou USER)
    @DeleteMapping("/acao-operacional")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<String> multiplosPerfis() {
        return ResponseEntity.ok("Sucesso: Ação permitida para múltiplos cargos.");
    }
}
