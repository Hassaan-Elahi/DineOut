package ReportingModule;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class EndOfDay_EventHandler
{
    final double TAX_PERCENT = 0.1;
    final double PROFIT_PERCENT = 0.1;


    public void createPdf(Context c, String dest) throws IOException, DocumentException {

        Document document = new Document();
        // step 2
        String filename = "Sales Report.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();

        /*  File file1 = new File(c.getFilesDir(),"files");
        if(!file1.exists())
        {
            file1.mkdir();
        }
        else
        {
            System.out.println("File already exists");
        }

        File file = new File(file1, DEST);
        //System.out.println(file.getPath());
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file,false));
        document.open();
        PdfPTable table = new PdfPTable(numberOfColumns);
        table.setSplitLate(false);
        table.setWidths(columnWidths);
        table.getDefaultCell().setBackgroundColor(BaseColor.CYAN);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        // Add the first header row. It says Sales Report
        Font f = new Font(Font.FontFamily.HELVETICA, 17, Font.NORMAL, GrayColor.GRAYWHITE);
        f.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase(TypeOfReport, f));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setColspan(numberOfColumns);
        cell.setFixedHeight(50);
        table.addCell(cell);
        //second row has header for columns like dish name prce
        for (int i = 0; i < numberOfColumns; i++) {
            cell = new PdfPCell(new Phrase(columnHeaders[i], f));

            cell.setBackgroundColor(BaseColor.GRAY);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        table.getDefaultCell().setBackgroundColor(BaseColor.PINK);
        table.setHeaderRows(2);
        f = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL, GrayColor.GRAYWHITE);
        f.setColor(BaseColor.BLACK);
        //Our Row data goes here
        for (TableRow rows:trows) {
            for (int i=0;i<numberOfColumns;i++) {
                cell = new PdfPCell(new Phrase(rows.cells[i].toString(), f));
                cell.setBackgroundColor(BaseColor.PINK);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
        }
        //                new int[]{60, 30,30,30};
        int[] innerwidths=new int[Totals.length+1];
        innerwidths[0]=0;
        for(int i=0;i<columnWidths.length-Totals.length;i++){
            innerwidths[0]+=columnWidths[i];
        }
        for(int i=1;i<=Totals.length;i++){
            innerwidths[i]= columnWidths[columnWidths.length-Totals.length+i-1];
        }
        PdfPTable innertable = new PdfPTable(Totals.length+1);
        innertable.setWidths(innerwidths);
        innertable.setWidthPercentage(100f);
        cell = new PdfPCell(new Phrase("Total", f));
        cell.setBackgroundColor(BaseColor.PINK);

        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        innertable.addCell(cell);
        f = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL, GrayColor.GRAYWHITE);
        f.setColor(BaseColor.BLACK);
        for (int i = 0; i <Totals.length; i++) {

            cell.setPhrase(new Phrase(Integer.toString(Totals[i])));
            cell.setBackgroundColor(BaseColor.CYAN);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            innertable.addCell(cell);

        }
        document.add(table);
        document.add(innertable);
        document.close();*/
    }




    public void YearlyReport(ArrayList<Date> time_stamp, ArrayList<Long> amount )
    {
        Date  today = new Date();
        int total_sales = 0;
        int total_profits = 0;
        int total_tax = 0;

        for (int i = 0; i < time_stamp.size(); i++)
        {
            if(time_stamp.get(i).getYear() == today.getYear())
            {
                total_sales += amount.get(i);
                total_profits += PROFIT_PERCENT * amount.get(i);
                total_tax += TAX_PERCENT * amount.get(i);
            }

        }

        //create pdf and send
    }
    public void MonthlyReport(ArrayList<Date> time_stamp, ArrayList<Long> amount)
    {
        Date  today = new Date();
        int total_sales = 0;
        int total_profits = 0;
        int total_tax = 0;

        for (int i = 0; i < time_stamp.size(); i++)
        {
            if(time_stamp.get(i).getMonth() == today.getMonth())
            {
                total_sales += amount.get(i);
                total_profits += PROFIT_PERCENT * amount.get(i);
                total_tax += TAX_PERCENT * amount.get(i);
            }

        }

        //Send these stats here

    }

    public void WeeklyReport(ArrayList<Date> time_stamp, ArrayList<Long> amount)
    {
        Date  today = new Date();
        int total_sales = 0;
        int total_profits = 0;
        int total_tax = 0;

        for (int i = 0; i < time_stamp.size(); i++)
        {
            //within
            if(time_stamp.get(i).getDay() <= today.getDay() && time_stamp.get(i).getDay() > today.getDay() - 7  )
            {
                total_sales += amount.get(i);
                total_profits += PROFIT_PERCENT * amount.get(i);
                total_tax += TAX_PERCENT * amount.get(i);
            }

        }

        //Send these stats here

    }
    public void DailyReport(ArrayList<Date> time_stamp, ArrayList<Long> amount)
    {
        Date  today = new Date();
        int total_sales = 0;
        int total_profits = 0;
        int total_tax = 0;

        for (int i = 0; i < time_stamp.size(); i++)
        {
            if(time_stamp.get(i).getDay() == today.getDay())
            {
                total_sales += amount.get(i);
                total_profits += PROFIT_PERCENT * amount.get(i);
                total_tax += TAX_PERCENT * amount.get(i);
            }

        }

        //Send these stats here

    }



    public void HandleCloseDayEvent()
    {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/orders");


        ref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                /*these two arrays will contain timestamps and amount paid for their order*/
                ArrayList<Date> time_stamp = new ArrayList<>();
                ArrayList<Long> amount_paid = new ArrayList<>();



                for (DataSnapshot userSnapshot : dataSnapshot.getChildren())
                {

                    Date date = new Date((Long) userSnapshot.child("amount").getValue());
                    time_stamp.add(date);
                    amount_paid.add((Long) userSnapshot.child("time_stamp").getValue());
                }

                Date current_date = new Date();
                Calendar calendar = Calendar.getInstance();

                int last_day_ofmonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


                if(current_date.getDay() == last_day_ofmonth && current_date.getMonth() == 12)
                {
                    YearlyReport(time_stamp,amount_paid);
                }
                else if(current_date.getDay() == last_day_ofmonth)
                {
                    MonthlyReport(time_stamp,amount_paid);
                }
                else if(dayOfWeek == 5)
                {
                    WeeklyReport(time_stamp,amount_paid);
                }
                else
                {
                    DailyReport(time_stamp,amount_paid);
                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                System.out.println("The read failed: " + databaseError.getCode());
            }


        });


    }



}
