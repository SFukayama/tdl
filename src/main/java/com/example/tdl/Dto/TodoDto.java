package com.example.tdl.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDto {

    private Integer id;

    private String title;

    private String content;

    private String tag;

    private String todoTag;

}