package com.example.springbootcrud.Repository;

import com.example.springbootcrud.Model.Children;
import com.example.springbootcrud.Model.WaitingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ChildrenRepo implements IChildrenRepo{
   @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Children> fetchAll() {
        String sql = "Select * from Children";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        System.out.println("ChildrenRepo");
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Children> fetchInfo() {
        String sql = "Select first_name,last_name,contact_number,parent_name from Children";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        System.out.println("ChildrenRepo");
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public Children addChildren(Children children) {
        String sql = "Insert into Children(id,first_name,last_name,age,birth_date,contact_number,parent_name ) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,children.getId(),children.getFirst_name(),children.getLast_name(),children.getAge(),children.getBirth_date(),children.getContact_number(),children.getParent_name());
        return null;
    }

    @Override
    public Children updateChildren(Children children) {
        String sqlQuery = "update Children set " +
                "first_name = ?, last_name = ?, age = ?, birth_date = ?, contact_number = ?,parent_name =?" +
                "where id = ?";
        jdbcTemplate.update(sqlQuery
                , children.getFirst_name()
                , children.getLast_name()
                , children.getAge()
                , children.getBirth_date()
                , children.getContact_number()
                , children.getId()
                ,children.getParent_name());
        return null;
    }

    @Override
    public boolean deleteChildren(int id) {
        String querry = "DELETE FROM Children WHERE id=?";
        jdbcTemplate.update(querry,id);
        return true;
    }

    @Override
    public List<WaitingList> fetchWaitingList() {
        String sql = "Select * from waiting_List";
        RowMapper<WaitingList> rowMapper1 = new BeanPropertyRowMapper<>(WaitingList.class);
        return jdbcTemplate.query(sql,rowMapper1);
    }

    @Override
    public WaitingList addWaitingList(WaitingList waitingList) {
        String sql = "Insert into waiting_List(id,child_name,parent_name,contact_number,email ) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,waitingList.getId(),waitingList.getChild_name(),waitingList.getParent_name(),waitingList.getContact_number(),waitingList.getEmail());
        return null;

    }

    @Override
    public WaitingList UpdateWaitingList(WaitingList waitingList) {
        String sqlQuery = "update waiting_List set " +
                "child_name = ?, parent_name = ?,contact_number = ?,email =?" +
                "where id = ?";
        jdbcTemplate.update(sqlQuery
                , waitingList.getChild_name()
                , waitingList.getParent_name()
                , waitingList.getContact_number()
                , waitingList.getEmail()
                ,waitingList.getId());
        return null;
    }

    @Override
    public boolean deleteWaitingList(int id) {
        String querry = "DELETE FROM waiting_List WHERE id=?";
        jdbcTemplate.update(querry,id);
        return true;
    }
}
