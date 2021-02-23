package com.wangbo.table2word.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.wangbo.table2word.domain.TableFileds;
import com.wangbo.table2word.domain.Tables;
import com.wangbo.table2word.mapper.QueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 创建word文档
 * 步骤: 1,建立文档 2,创建一个书写器 3,打开文档 4,向文档中写入数据 5,关闭文档
 *
 * @author WangBo
 * @since 2020/1/6 19:22
 **/
@Service
public class DateToWordUtil {

    @Value("${database}")
    private String dataName;

    @Autowired
    QueryMapper queryMapper;

    public void toWord(List<Tables> tables) {

        // 创建word文档,并设置纸张的大小
        Document document = new Document(PageSize.A4);
        try {
            // 创建word文档
            RtfWriter2.getInstance(document, new FileOutputStream(System.getProperty("user.dir") + "/out/" + dataName + ".doc"));
            document.open();

            Paragraph ph = new Paragraph();
            Font f = new Font();
            Paragraph p = new Paragraph(dataName, new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));

            p.setAlignment(1);
            document.add(p);
            ph.setFont(f);

            for (int i = 0; i < tables.size(); i++) {
                document.add(new Paragraph(""));

                Table table = new Table(6);
                table.setBorderWidth(1);
                table.setBorderColor(Color.BLACK);
                table.setPadding(0);
                table.setSpacing(0);

                // 添加表头的元素，并设置表头背景的颜色
                Color color = new Color(176, 196, 222);

                Cell cell = new Cell("num");
                cell.setBackgroundColor(color);
                cell.setHeader(true);
                table.addCell(cell);

                cell = new Cell("file");
                cell.setBackgroundColor(color);
                table.addCell(cell);

                cell = new Cell("type");
                cell.setBackgroundColor(color);
                table.addCell(cell);

                cell = new Cell("isNull");
                cell.setBackgroundColor(color);
                table.addCell(cell);

                cell = new Cell("key");
                cell.setBackgroundColor(color);
                table.addCell(cell);

                cell = new Cell("comment");
                cell.setBackgroundColor(color);
                table.addCell(cell);

                table.endHeaders();

                // 表格主体
                List<TableFileds> fields = queryMapper.getTable(tables.get(i).getName());
                for (int k = 0; k < fields.size(); k++) {
                    table.addCell((k + 1) + "");
                    table.addCell(fields.get(k).getField());
                    table.addCell(fields.get(k).getType());
                    table.addCell(fields.get(k).getNull());
                    table.addCell(fields.get(k).getKey());
                    table.addCell(fields.get(k).getComment());
                }

                //表头
                String all = (i + 1) + " : " + tables.get(i).getName() + " : " + tables.get(i).getComment();
                Paragraph paragraph = new Paragraph(all);

                //写入表说明
                document.add(paragraph);
                //生成表格
                document.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
