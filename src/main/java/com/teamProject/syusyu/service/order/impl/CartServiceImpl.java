package com.teamProject.syusyu.service.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProductDTO;
import com.teamProject.syusyu.service.order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    CartProdDAO cartProdDAO;

    @Autowired
    public CartServiceImpl(CartProdDAO cartProdDAO) {
        this.cartProdDAO = cartProdDAO;
    }

    @Override
    public int add(CartProductDTO cartProductDTO) throws Exception {
        return cartProdDAO.insert(cartProductDTO);
    }

    @Override
    public List<CartProductDTO> getList(int mbrId) throws Exception {
        return cartProdDAO.select(mbrId);
    }

    @Override
    public int modify(CartProductDTO cartProductDTO) throws Exception {
        return cartProdDAO.update(cartProductDTO);
    }

    @Override
    public int remove(int[] cartProdId) throws Exception {
        return cartProdDAO.delete(cartProdId);
    }


}
