package br.com.marzo.greeting_service.model

import com.fasterxml.jackson.annotation.JsonProperty

class Greeting {

    constructor();
    constructor(id: Long) {
        this.id = id
    }

    constructor(id: Long, nome: String) {
        this.id = id
        this.nome = nome
    }

    @JsonProperty("id_test")
    var id: Long? = null;

    @JsonProperty("nome")
    var nome: String? = null;
}