package utils;

public class PagingUtil {
	public static String pagingBlock(int totalCount,int pageSize,int blockSize,
			int pageNum,String reqUri) {
		String pagingRes="";
		
		int totalPage=(int)Math.ceil((double)totalCount/pageSize);
		
		int pageTemp=(((pageNum-1)/blockSize)*blockSize)+1;
		// [first] [prev block]  6 7 8 9 10 [next block] [last]
		if(pageTemp!=1) {
			pagingRes = "<a href='"+reqUri+"?pageNum=1'>[first]</a>";
			pagingRes += "&nbsp;";
			pagingRes += "<a href='"+reqUri+"?pageNum="+(pageTemp-1)+"'>[prev block]</a>";
		}
		int blockCount=1;
		while(blockCount<=blockSize && pageTemp<=totalPage) {
			if(pageTemp==pageNum) {
				pagingRes+="&nbsp;"+pageTemp+"&nbsp;";
			}else {	
				pagingRes+="&nbsp;<a href='"+reqUri+"?pageNum="+pageTemp+"'>"
						+pageTemp+"</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}
		if(pageTemp<=totalPage) {
			pagingRes+="<a href='"+reqUri+"?pageNum="+pageTemp+"'>[next block]</a>";
			pagingRes+="&nbsp;";
			pagingRes+="<a href='"+reqUri+"?pageNum="+totalPage+"'>[last]</a>";
		}
		return pagingRes;
	}
	
	public static String pagingCenter(int totalCount,int pageSize,int pageBlock,
			int pageNum,String reqUri) {
		String pagingRes="";
		int totalPage = (int)Math.ceil((double)totalCount/pageSize);
		int div = pageBlock/2;
		int pageTemp = pageNum-div;
		if(pageTemp<=0)pageTemp=1;
		if(pageTemp!=1) {
			pagingRes+="<a href='"+reqUri+"?pageNum=1'>[first]</a>";
		}
		int count=1;
		while(count<=pageBlock && pageTemp<=totalPage) {
			if(pageTemp==pageNum) {
				pagingRes +="&nbsp;"+pageTemp+"&nbsp;";
			}else {
				pagingRes += "&nbsp;<a href='"+reqUri+"?pageNum="+pageTemp
						+"'>"+pageTemp+"</a>&nbsp;";
			}
			pageTemp++;
			count++;
		}
		if(pageTemp<=totalPage) {
			pagingRes+= "<a href='"+reqUri+"?pageNum="+totalPage
					+"'>[last]</a>";
		}
		return pagingRes;
	}
}

//public class PagingUtil {
//	public static String pagingBlock(int totalCount, int pageSize, int blockSize,
//			int pageNum, String reqUri) {
//		String pagingRes="";
//		
//		int totalPage=(int)Math.ceil((double)totalCount/pageSize);
//		
//		int blockStart = Math.max(1, pageNum - blockSize / 2);
//		int blockEnd = Math.min(totalPage, blockStart + blockSize - 1);
//
//		// [first] [prev block] 3 4 5 6 7 [next block] [last]
//		if(blockStart > 1) {
//		    pagingRes="<a href='"+reqUri+"?pageNum=1'>[first]</a>";
//		    pagingRes += "&nbsp";
//		    pagingRes += "<a href='"+reqUri+"?pageNum="+(blockStart-1)+"'>[prev block]</a>";
//		}
//
//		while(blockStart <= blockEnd) {
//		    if(blockStart == pageNum) {
//		        pagingRes+="&nbsp;"+blockStart+"&nbsp;";				
//		    } else {
//		        pagingRes+="&nbsp;<a href='"+reqUri+"?pageNum="+blockStart+"'>"
//		            +blockStart+"</a>&nbsp;";
//		    }
//		    blockStart++;
//		}
//
//		if(blockEnd < totalPage) {
//		    pagingRes+="<a href='"+reqUri+"?pageNum="+(blockEnd+1)+"'>[next block]</a>";
//		    pagingRes+="&nbsp;";
//		    pagingRes+="<a href='"+reqUri+"?pageNum="+totalPage+"'>[last]</a>";
//		}
//		
//		return pagingRes;
//	}
//}

//public class PagingUtil {
//	public static String pagingBlock(int totalCount, int pageSize, int blockSize,
//		int pageNum, String reqUri) {
//		String pagingRes="";
//				
//		int totalPage=(int)Math.ceil((double)totalCount/pageSize);
//		
//		int pageTemp=(((pageNum-1)/blockSize)*blockSize)+1;
//		// [first] [prev block] 3 4 5 6 7 [next block] [last]
//		if(pageTemp!=1) {
//		pagingRes="<a href='"+reqUri+"?pageNum=1'>[first]</a>";
//		pagingRes += "&nbsp";
//		pagingRes += "<a href='"+reqUri+"?pageNum="+(pageTemp-1)+"'>[prev block]</a>";
//		}	
//		int blockCount=1;
//		while(blockCount<=blockSize && pageTemp<=totalPage) {
//			if(pageTemp==pageNum) {
//				pagingRes+="&nbsp;"+pageTemp+"&nbsp;";				
//			}else {
//				pagingRes+="&nbsp;<a href='"+reqUri+"?pageNum="+pageTemp+"'>"
//						+pageTemp+"</a>&nbsp;";
//			}
//			pageTemp++;
//			blockCount++;
//		}
//		if(pageTemp<=totalPage) {
//			pagingRes+="<a href='"+reqUri+"?pageNum="+pageTemp+"'>[next block]</a>";
//			pagingRes+="&nbsp;";
//			pagingRes+="<a href='"+reqUri+"?pageNum="+totalPage+"'>[last]</a>";
//		}
//		
//		return pagingRes;
//	}
//}
