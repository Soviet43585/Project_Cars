package com.example.demo.dto.request;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateCarRequest extends CreateCarRequest {
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
