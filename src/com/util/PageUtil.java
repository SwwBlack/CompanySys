package com.util;

import com.sun.xml.internal.ws.api.pipe.Tube;

//分页辅助类
public class PageUtil {
	//
	public static Page createPage(int everyPage,int totalCount,int currentPage){
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int tTotalCount = totalCount;
		int totalPage = getTotalPage(everyPage, tTotalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, tTotalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
	}
	//
    public static int getEveryPage(int everypage){//获取每页记录数
    	return everypage==0?10:everypage;
    }
    public static int getCurrentPage(int currentPage){//获取当前页
    	return currentPage==0?1:currentPage;
    }
    //获取总页数
    public static int getTotalPage(int everypage,int totalCount){
    	int totalpage = 0;
    	if(totalCount!=0&&totalCount%everypage==0){
    		totalpage = totalCount/everypage;
    	}else {
			totalpage = totalCount/everypage+1;
		}
    	return totalpage;
    }
    //获得起始位置
    public static int getBeginIndex(int everyPage,int currentPage){
    	return (currentPage-1)*everyPage;
    }
    //是否有上一页
    public static boolean getHasPrePage(int currentPage){
    	return currentPage==1?false:true;
    }
    //是否有下一页
    public static boolean getHasNextPage(int totalPage,int currentPage){
    	return currentPage==totalPage?false:true;
    }
}
