package com.example.tdl.Service;

import com.example.tdl.Dto.TodoDto;
import com.example.tdl.Entity.TodoEntity;
import com.example.tdl.Repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    @NonNull
    private TodoRepository todoRepository;
    @NonNull
    private final ModelMapper modelMapper;

    public List<TodoDto> getTodoList() {
        List<TodoEntity> todoList = todoRepository.getTodoList();
        List<TodoDto> list = new ArrayList<>();
        for (TodoEntity todoEntity : todoList) {
            TodoDto map = modelMapper.map(todoEntity, TodoDto.class);
            list.add(map);
        }
        return list;
    }

    public TodoDto getTodoDetail(Integer id) {
        TodoEntity todoDetail = todoRepository.getTodoDetail(id);
        return modelMapper.map(todoDetail, TodoDto.class);
    }

    @Transactional //　トランザクション：途中で処理が失敗したら登録されないようにするアノテーション
    public void createNewTodo(TodoDto dto) {
        TodoEntity todoEntity = modelMapper.map(dto, TodoEntity.class);
        todoRepository.createNewTitle(todoEntity.getTitle());
        todoRepository.createNewDetail(todoEntity.getContent(), todoEntity.getTodoTag());
    }

    @Transactional
    public void updateTodo(TodoDto dto) {
        TodoEntity todoEntity = modelMapper.map(dto, TodoEntity.class);
        todoRepository.updateTodo(todoEntity);
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteTitle(id);
        todoRepository.deleteContent(id);
    }

    public List<TodoDto> getTagList() {
        List<TodoEntity> tagList = todoRepository.getTagList();
        List<TodoDto> list = new ArrayList<>();
        for (TodoEntity todoEntity : tagList) {
            TodoDto map = modelMapper.map(todoEntity, TodoDto.class);
            list.add(map);
        }
        return list;
    }
}
