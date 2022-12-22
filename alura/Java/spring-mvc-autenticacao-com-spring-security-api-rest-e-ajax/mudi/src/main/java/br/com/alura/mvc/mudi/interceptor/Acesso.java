package br.com.alura.mvc.mudi.interceptor;

import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Acesso {
    private String path;
    private LocalDateTime data;
    private Duration duracao;
}
