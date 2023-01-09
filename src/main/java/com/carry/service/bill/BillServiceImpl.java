package com.carry.service.bill;

import com.carry.dao.bill.BillMapper;
import com.carry.pojo.Bill;

import java.util.List;

public class BillServiceImpl implements BillService{
    //service层调dao层，组合Dao
    private BillMapper billMapper;
    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    //查询记录数，以实现订单列表分页功能
    public int getBillCount(String productName, int providerId, int isPayment) {
        return billMapper.getBillCount(productName, providerId, isPayment);
    }

    //通过商品名称、供应商id、是否付款查询订单列表-模糊查询-billList
    public List<Bill> getBillList(String productName, int providerId, int isPayment) {
        return billMapper.getBillList(productName, providerId, isPayment);
    }

    //增加订单
    public boolean add(Bill bill) {
        boolean flag = false;
        int addRows = billMapper.add(bill);
        if (addRows > 0){
            flag = true;
        }
        return flag;
    }

    //通过delId删除Bill
    public boolean deleteBillById(int delId) {
        boolean flag = false;
        int deleteRows = billMapper.deleteBillById(delId);
        if (deleteRows > 0){
            flag = true;
        }
        return flag;
    }

    //通过billId获取Bill
    public Bill getBillById(int id) {
        return billMapper.getBillById(id);
    }

    //修改订单信息
    public boolean modify(Bill bill) {
        boolean flag = false;
        int modifyRows = billMapper.modify(bill);
        if (modifyRows > 0){
            flag = true;
        }
        return flag;
    }
}
