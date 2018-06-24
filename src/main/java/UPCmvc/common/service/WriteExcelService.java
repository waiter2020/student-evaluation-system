package UPCmvc.common.service;

import UPCmvc.common.model.Grade;
import UPCmvc.evaluation.model.GroupEvaGrade;
import UPCmvc.evaluation.model.StudentEvaGrade;
import UPCmvc.evaluation.repository.GroupEvaGradeRepository;
import UPCmvc.evaluation.repository.StudentEvaGradeRepository;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;


/**
 * Created by Jaxlying on 2016/10/15.
 */
@Service
public class WriteExcelService {

    @Autowired
    StudentEvaGradeRepository studentEvaGradeRepository;

    @Autowired
    GroupEvaGradeRepository groupEvaGradeRepository;

    public void writeExcel(Iterator<Grade> grades, int classId) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        sheet.setColumnWidth((short) 0, (short) 4000);
        sheet.setColumnWidth((short) 1, (short) 9000);
        HSSFFont font = wb.createFont();
        font.setFontName("Verdana");
        font.setBoldweight((short) 100);
        font.setFontHeight((short) 300);
        font.setColor(HSSFColor.BLACK.index);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBottomBorderColor(HSSFColor.RED.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setFont(font);

        HSSFRow row = null;
        HSSFCell cell = null;

        short i = -1;

        row = sheet.createRow(0);
        row.setHeight((short) 500);

        //1
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("学号");


        //2
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("姓名");


        //3
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("学分绩");


        //4
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("评议成绩");

        //5
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("班级测评");

        //6
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("测评小组测评");

        //7
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("记实项目");

        //8
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("基础性素质测评成绩");

        //9
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("发展性素质测评成绩");

        //10
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("五分制总成绩");


        //11
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("班级测评A");

        //12
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("班级测评B");

        //13
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("班级测评C");

        //14
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("班级测评D");

        //15
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("小组测评A");

        //16
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("小组测评B");

        //17
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("小组测评C");

        //18
        cell = row.createCell(++i);
        cell.setCellStyle(style);
        cell.setCellValue("小组测评D");




        short rowNum = 1;
        while (grades.hasNext()) {

            short cellNum = -1;
            Grade grade = grades.next();

            row = sheet.createRow(rowNum);
            row.setHeight((short) 500);

            StudentEvaGrade studentEvaGrade=studentEvaGradeRepository.findByStudentId(grade.getStuNum());
            GroupEvaGrade groupEvaGrade=groupEvaGradeRepository.findFirstByStudentId(grade.getStuNum());


            //1
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(String.valueOf(grade.getStuNum()));


            //2
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getStuName());

            //3
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getStudy());

            //4
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getEvaluate());


            //5
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getStuEva());

            //6
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getGroupEva());


            //7
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getDocumentary());


            //8
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getBasis());

            //9
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getDevelopment());


            //10
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(grade.getSum());


            //11
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(studentEvaGrade.getGradeANum());

            //12
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(studentEvaGrade.getGradeBNum());

            //13
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(studentEvaGrade.getGradeCNum());

            //14
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(studentEvaGrade.getGradeDNum());

            //15
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(groupEvaGrade.getGradeANum());

            //16
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(groupEvaGrade.getGradeBNum());

            //17
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(groupEvaGrade.getGradeCNum());

            //18
            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(groupEvaGrade.getGradeDNum());

            ++rowNum;
        }

        File dir = new File("uploadFiles/excel");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File("uploadFiles/excel/class" + classId + ".xls");
        FileOutputStream os = new FileOutputStream(file);
        wb.write(os);
        os.flush();
        os.close();
        System.out.println("生成excel成功");

    }
}
