package com.example.tdl.Controller;

import com.example.tdl.Dto.TodoDto;
import com.example.tdl.Form.TodoForm;
import com.example.tdl.Service.TodoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    @NonNull
    private final TodoService todoService;
    @NonNull
    private final ModelMapper modelMapper;

    @GetMapping
    public String showTodoList(Model model) {
        List<TodoDto> todoList = todoService.getTodoList();
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

    @RequestMapping("/{id}")
    public String todoDetail(@PathVariable Integer id, Model model) {
        TodoDto todoDetail = todoService.getTodoDetail(id);
        model.addAttribute("todoDetail", todoDetail);
        return "todoDetail";
    }

    @GetMapping("/new")
    public String showCreationForm(@ModelAttribute TodoForm todoform,Model model) {
        List<TodoDto> tagList = todoService.getTagList();
        model.addAttribute ("tag", tagList);
        return "todoNew";
    }

    @PostMapping // ここがHTMLの th:action="@{/tod}" とつながる
    public String createNewTodo(TodoForm form) {
        TodoDto dto = modelMapper.map(form, TodoDto.class);
        todoService.createNewTodo(dto);
        return "redirect:/todo";
    }

    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        TodoDto todoDetail = todoService.getTodoDetail(id);
        model.addAttribute("todo", todoDetail);
        model.addAttribute("todoForm", new TodoForm());
        List<TodoDto> tagList = todoService.getTagList();
        model.addAttribute ("tag", tagList);
        return "todoUpdate";
    }

    @PostMapping("/{id}")
    public String updateTodo(TodoForm form) {
        TodoDto dto = modelMapper.map(form, TodoDto.class);
        todoService.updateTodo(dto);
        return "redirect:/todo/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteTodo(TodoForm todoForm) {
        todoService.deleteTodo(todoForm.getId());
        return "redirect:/todo";
    }

}
