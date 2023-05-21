package com.example.tdl.Form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoForm {

    private Integer id;

    private String title;

    private String content;

    private String tag;

    private String todoTag;

}
