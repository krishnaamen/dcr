package com.example.springbootcrud.Service;

import com.example.springbootcrud.Model.Children;
import com.example.springbootcrud.Model.WaitingList;

import java.util.List;

public interface IChildrenService {
    List<Children> fetchAll();
    List<Children> fetchInfo();
    Children addChildren(Children children);
    Children updateChildren(Children children);
    boolean deleteChildren(int id);
    List<WaitingList> fetchWaitingList();
    WaitingList addWaitingList(WaitingList waitingList);
    WaitingList UpdateWaitingList(WaitingList waitingList);
    boolean deleteWaitingList(int id);
}
