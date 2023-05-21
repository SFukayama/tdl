package com.example.tdl.Repository;

import com.example.tdl.Entity.TodoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoRepository {
    @Select("select * from todo")
    List<TodoEntity> getTodoList();

    @Select("select t.id, t.title, d.content, d.todo_tag from todo t inner join detail d on t.id = d.todo_id where id = #{id}")
    TodoEntity getTodoDetail(Integer id);

    @Insert("insert into todo (title) values (#{title})")
    void createNewTitle(String title);

    @Insert("insert into detail (content, todo_tag) values (#{content}, #{todoTag})")
    void createNewDetail(String content, String todoTag);

    @Update("update detail set content = #{content}, todo_tag = #{todoTag} where todo_id = #{id}")
    void updateTodo(TodoEntity todoEntity);

    @Delete("delete from todo where id = #{id}")
    void deleteTitle(Integer id);

    @Delete("delete from detail where todo_id = #{id}")
    void deleteContent(Integer id);

    @Select("select * from tag")
    List<TodoEntity> getTagList();

}
