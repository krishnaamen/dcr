package com.example.springbootcrud.Service;

import com.example.springbootcrud.Model.Children;
import com.example.springbootcrud.Model.WaitingList;
import com.example.springbootcrud.Repository.IChildrenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChildrenService implements IChildrenService{
    @Autowired
    IChildrenRepo iChildrenRepo;
    @Override
    public List<Children> fetchAll() {
        //System.out.println("ChildrenService");
        return iChildrenRepo.fetchAll();
    }

    @Override
    public List<Children> fetchInfo() {
        return iChildrenRepo.fetchInfo();
    }

    @Override
    public Children fetchSingleChild(int id) {
        return iChildrenRepo.fetchSingleChild(id);
    }

    @Override
    public Children addChildren(Children children) {
        return iChildrenRepo.addChildren(children);
    }

    @Override
    public Children updateChildren(Children children) {
        return iChildrenRepo.updateChildren(children);
    }

    @Override
    public boolean deleteChildren(int id) {
        return iChildrenRepo.deleteChildren(id);
    }

    @Override
    public List<WaitingList> fetchWaitingList() {
        return iChildrenRepo.fetchWaitingList();
    }

    @Override
    public WaitingList addWaitingList(WaitingList waitingList) {
        return iChildrenRepo.addWaitingList(waitingList);
    }

    @Override
    public WaitingList UpdateWaitingList(WaitingList waitingList) {
        return iChildrenRepo.UpdateWaitingList(waitingList);
    }

    @Override
    public boolean deleteWaitingList(int id) {
        return iChildrenRepo.deleteWaitingList(id);
    }
}
