package com.tamasia.api_alunos.exception;

public class AlunoNaoEncontradoException extends RuntimeException{

    public  AlunoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
