package com.technoglitz.hashdb;

import java.util.Collection;
import java.util.HashMap;

import com.technoglitz.vo.OrderVO;


/**
 * @author vt71670
 *
 */
public class TmpBuffer {
    /**
     * 
     */
    public static HashMap<String, OrderVO> bookDB = new HashMap<String, OrderVO>();
    /**
     * 
     */
    public static int counter = 0;
    /**
     * @param bookVO
     */
    public static void insertOrder(OrderVO bookVO){
        if(TmpBuffer.bookDB.size() > 10000){
             TmpBuffer.bookDB.clear();
             counter++;
        }
        TmpBuffer.bookDB.put(bookVO.getOrderName(), bookVO);
    }

    /**
     * @param bookName
     * @return
     */
    public static OrderVO getOrder(String bookName){
        return TmpBuffer.bookDB.get(bookName);
    }
    
    /**
     * @param bookName
     * @return
     */
    public static Collection<OrderVO> getAll(){
    	return TmpBuffer.bookDB.values();
    }

}