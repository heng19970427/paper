package com.zr.resolver;

import com.zr.pojo.QuesCate;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyExcelViewResolver extends AbstractXlsView{
    @Override
    protected void buildExcelDocument(Map<String, Object> model, org.apache.poi.ss.usermodel.Workbook workbook, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        String fileName = "下载列表.xls";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/ms-excel");// 文件下载
        response.setHeader("Content-Disposition", "inline; filename=" + new String(fileName.getBytes(), "iso8859-1"));
        OutputStream outputStream = response.getOutputStream();
        HSSFWorkbook book = (HSSFWorkbook) workbook;

        List<QuesCate> quesCateList= (List<QuesCate>) model.get("quesCateList");
        HSSFSheet[] sheets=new HSSFSheet[quesCateList.size()];

        //记录填空题标号
        List<Integer> BlankNum=new ArrayList<Integer>();
        String[] headers1= new String[]{"题干","知识点","空的个数","答案","难度系数","试题来源"};
        String[] headers2=new String[]{"题干","知识点","答案","难度系数","试题来源"};

        for (int i = 0; i <quesCateList.size() ; i++) {
            //动态生成sheet
            sheets[i]=book.createSheet(quesCateList.get(i).getQcName());
            //取出每个sheet表头内容
            if(quesCateList.get(i).getProbCate().getP_id()==2){
                BlankNum.add(i);
            }
        }

        //为每个sheet创建第一行表头
        HSSFRow[] rows=new HSSFRow[sheets.length];
        for (int i = 0; i < rows.length; i++){
            rows[i]=sheets[i].createRow(0);

        }


//        String[] headers1=new String[]{"名字","班级","学号"};
//        String[] headers2=new String[]{"学号","物理","英语"};
        //遍历sheet,如果是填空题就用headers2
        for (int i = 0; i <sheets.length; i++) {
            if(i==(BlankNum.contains(i)?i:-1)){
                for (int j = 0; j <headers1.length; j++) {
                    rows[i].createCell(j).setCellValue(headers1[j]);
                }
            }
            else{
                for (int j = 0; j <headers2.length; j++) {
                    rows[i].createCell(j).setCellValue(headers2[j]);
                }
            }
        }

        book.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
