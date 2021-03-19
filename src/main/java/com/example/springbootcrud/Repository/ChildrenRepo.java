package com.example.springbootcrud.Repository;

import com.example.springbootcrud.Model.Children;
import com.example.springbootcrud.Model.WaitingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ChildrenRepo implements IChildrenRepo{
   @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Children> fetchAll() {
        String sql = "Select * from Children";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Children> fetchInfo() {
        String sql = "Select first_name,last_name,contact_number,parent_name from Children";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public Children fetchSingleChild(int id) {
        String sql = "Select * from Children where id =?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<Children>(){
            @Override
            public Children mapRow(ResultSet rs, int rownum) throws SQLException
            {
                Children children = new Children();
                children.setId(rs.getInt(1));
                children.setFirst_name(rs.getString(2));
                children.setLast_name(rs.getString(3));
                children.setAge(rs.getInt(4));
                children.setBirth_date(rs.getDate(5));
                children.setContact_number(rs.getString(6));
                children.setParent_name(rs.getString(7));
                return children;
            }},id);


            }



    @Override
    public Children addChildren(Children children) {
        String sql = "Insert into Children(first_name,last_name,age,birth_date,contact_number,parent_name ) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,children.getFirst_name(),children.getLast_name(),children.getAge(),children.getBirth_date(),children.getContact_number(),children.getParent_name());
        return null;
    }

    @Override
    public Children updateChildren(Children children) {
        String sqlQuery = "update Children set " +
                "first_name = ?, last_name = ?, age = ?, birth_date = ?, contact_number = ?,parent_name =?"+
                "where id = ?";
        jdbcTemplate.update(sqlQuery
                , children.getFirst_name()
                , children.getLast_name()
                , children.getAge()
                , children.getBirth_date()
                , children.getContact_number()
                ,children.getParent_name()
                , children.getId());
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
        String sql = "Insert into waiting_List(child_name,parent_name,contact_number,email ) values(?,?,?,?)";
        jdbcTemplate.update(sql,waitingList.getChild_name(),waitingList.getParent_name(),waitingList.getContact_number(),waitingList.getEmail());
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
