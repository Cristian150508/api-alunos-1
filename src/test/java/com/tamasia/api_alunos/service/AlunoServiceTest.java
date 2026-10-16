package com.tamasia.api_alunos.service;

import com.tamasia.api_alunos.DTO.AlunoRequest;
import com.tamasia.api_alunos.DTO.AlunoResponse;
import com.tamasia.api_alunos.exception.EmailCadastradoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AlunoServiceTest {

    private AlunoService service;

    @BeforeEach
    void setUp(){
        service = new AlunoService();
    }

    @Test
    void deveCadastrarAlunoQuandoDadosForemValidos() {

        // Arrange
        //service = new AlunoService();

         AlunoRequest request = new AlunoRequest("Cristian",
                "cris@gmail.com",
                "senha",
                LocalDate.of(2008, 05, 15), 9);
        //Act
        AlunoResponse response = service.cadastrarAluno(request);

        //Assert
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getId()).isGreaterThan(0);
    }

    @Test
    void deveReceberExecaoQuandoEmailRepetidoNaRequisicao() {

        //Arrange
        //service = new AlunoService();
        AlunoRequest request1 = new AlunoRequest("Cris","cristian@gamil.com","senha",LocalDate.of(2000,01,01),9);
        AlunoRequest request2 = new AlunoRequest("Alice","cristian@gamil.com","1234", LocalDate.of(2000,02,02),9);

        AlunoResponse response1 = service.cadastrarAluno(request1);
        //Act
        Assertions.assertThatThrownBy(() -> service.cadastrarAluno(request2)).isInstanceOf(EmailCadastradoException.class)
                .hasMessage("Email já cadastrado");
    }
}
