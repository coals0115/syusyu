package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartProdDAOImpl implements CartProdDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.cartMapper.";

    /**
     * 장바구니에 상품을 추가한다.
     *
     * @param cartProductDTO 장바구니에 추가할 상품 정보
     * @return 추가된 상품의 ID
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public int insert(CartProdDTO cartProductDTO) throws Exception {
        return session.insert(namespace + "insert", cartProductDTO);
    }


    /**
     * 사용자 아이디에 해당하는 장바구니 정보를 가져온다.
     *
     * @param mbrId 장바구니를 조회할 사용자의 아이디
     * @return 해당 사용자의 장바구니에 담긴 상품들의 정보를 담은 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public List<CartProdDTO> selectAll(int mbrId) throws Exception {
        return session.selectList(namespace + "selectAll", mbrId);
    }

    /**
     * 장바구니에 담긴 특정 상품 정보를 수정한다.
     *
     * @param cartProductDTO 수정할 상품 정보
     * @return 수정된 상품의 ID
     * @throws Exception DB 수정 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public int update(CartProdDTO cartProductDTO) throws Exception {
        return session.update(namespace + "update", cartProductDTO);
    }

    /**
     * 장바구니에서 특정 상품들을 제거한다.
     *
     * @param cartProdNo 제거할 장바구니상품번호 배열
     * @param delrId 상품을 제거하는 사용자의 ID
     * @return 제거된 상품의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public int delete(int[] cartProdNo, int delrId) throws Exception {
        Map<String, Object> deleteParam = new HashMap<>();
        deleteParam.put("cartProdNo", cartProdNo);
        deleteParam.put("delrId", delrId + "");

        return session.delete(namespace + "delete", deleteParam);
    }

    @Override
    public int deleteTest(int[] cartProdNoArr) throws Exception {
        return session.delete(namespace + "deleteTest", cartProdNoArr);
    }
    /**
     * 장바구니의 모든 상품을 제거한다.
     *
     * @return 제거된 상품의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public int deleteAllTest() throws Exception {
        return session.delete(namespace + "deleteAllTest");
    }

    @Override
    public List<CartProdDTO> selectAllTest() throws Exception {
        return session.selectList(namespace + "selectAllTest");
    }

    @Override
    public CartProdDTO selectOneTest(int cartProdNo) throws Exception {
        return session.selectOne(namespace + "selectOneTest", cartProdNo);
    }
}
