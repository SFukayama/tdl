package com.example.tdl.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoEntity {

    private Integer id;

    private String title;

    private String content;

    private String tag;

    private String todoTag;

}
