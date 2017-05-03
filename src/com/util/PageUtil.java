package com.util;

import com.sun.xml.internal.ws.api.pipe.Tube;

//��ҳ������
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
    public static int getEveryPage(int everypage){//��ȡÿҳ��¼��
    	return everypage==0?10:everypage;
    }
    public static int getCurrentPage(int currentPage){//��ȡ��ǰҳ
    	return currentPage==0?1:currentPage;
    }
    //��ȡ��ҳ��
    public static int getTotalPage(int everypage,int totalCount){
    	int totalpage = 0;
    	if(totalCount!=0&&totalCount%everypage==0){
    		totalpage = totalCount/everypage;
    	}else {
			totalpage = totalCount/everypage+1;
		}
    	return totalpage;
    }
    //�����ʼλ��
    public static int getBeginIndex(int everyPage,int currentPage){
    	return (currentPage-1)*everyPage;
    }
    //�Ƿ�����һҳ
    public static boolean getHasPrePage(int currentPage){
    	return currentPage==1?false:true;
    }
    //�Ƿ�����һҳ
    public static boolean getHasNextPage(int totalPage,int currentPage){
    	return currentPage==totalPage?false:true;
    }
}
