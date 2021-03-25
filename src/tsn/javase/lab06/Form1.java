package tsn.javase.lab06;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Form1 extends javax.swing.JFrame {

    public class MyPicture extends JPanel { // КЛАСС РИСОВАНИЯ СВОЕЙ КАРТИНКИ

        Graphics2D canvas;   // Класс рисования
        BufferedImage buff;  // Буферное изображение
        int x = 400; // Константа размера полотна по х
        int y = 250; // Константа размера полотна по y

        MyPicture() {
            // Создаем буферное полотно для рисования размером x-y
            buff = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            // Создаем двустороннюю связь между буферным изображением и классом рисования
            canvas = (Graphics2D) buff.getGraphics();

            canvas.setPaint(Color.WHITE); // Устанавливаем цвет рисования серым
            canvas.fillRect(0, 0, x, y); // Заливаем полотно для рисования

            canvas.setPaint(Color.BLACK);  // Устанавливаем цвет рисования черным
            //canvas.drawOval(100, 80, 90, 100);  // Отрисовываем большой овал
            //canvas.drawLine(20, 90, 180, 180);

            //canvas.drawArc(100, 115, 40, 30, 180, 180); // Отрисовываем дугу по середине овала
            //canvas.drawArc(140, 115, 49, 30, 180, 180);
            canvas.drawArc(120, 100, 40, 40, 240, -300);
            //canvas.drawArc(120, 100, 40, 40, 90, 120);
            canvas.drawLine(130, 137, 130, 150);
            canvas.drawLine(150, 137, 150, 150);
            canvas.drawLine(130, 150, 150, 150);
            canvas.drawLine(135, 127, 133, 137);
            canvas.drawLine(130, 137, 150, 137);
            canvas.drawLine(135, 127, 144, 127);
            canvas.drawLine(144, 127, 147, 137);
            canvas.drawArc(135, 145, 10, 10, 180, 180);
            
            //canvas.drawRect(122, 160, 50, 60);
            //рисуем два мелньких круга сверху и снизу
            //canvas.drawOval(140, 70, 10, 10);
            //canvas.drawOval(122, 160, 50, 60);
            //устанавливаем стиль и пишим текст
            canvas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
            canvas.drawString("Java!", 85, 50);
            
            try {
                // При помощи созданной функции заливки закрашиваем две части главного овала
                // и два маленьких кружка
                fill(130, 120, Color.WHITE, Color.YELLOW);
                fill(137, 128, Color.WHITE, Color.ORANGE);
                fill(137,140, Color.WHITE, Color.BLACK);
                fill(138, 152, Color.WHITE, Color.GRAY);
                ///fill(150, 185, Color.GRAY, Color.BLACK);
            } catch (Exception ex) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Отрисовываем панель и компоненты на ней
            g.drawImage(buff, 0, 0, this); // Отрисовываем буфер с нашим изображением на панель
        }

        private void fill(int x, int y, Color bgcolor, Color color) throws Exception {
            // Заливка фигур методом ромба, параметры: х,y- координаты начала заливки, 
            // bgcolor-цвет который надо закрашивать, color-цвет которым надо закрашивать 
            ArrayList<Point> point = new ArrayList<>(); // Создаем динамический массив точек
            point.add(new Point(x, y)); // Добавляем начальную точку в массив
            Color oldColor = canvas.getColor(); // Сохраняем старый цвет рисования
            canvas.setPaint(color); //ставим цвет закраски
            while (point.size() > 0) { // Пока в массиве имеются точки для закрашивания
                Point p = point.remove(0); // Считываем координаты первой точки, и удаляем ее из массива
                x = p.x;
                y = p.y;
                if (bgcolor.getRGB() == buff.getRGB(x, y)) { // Если ее надо нам закрасить
                    canvas.drawLine(x, y, x, y); // Закрашиваем точку
                    point.add(new Point(x + 1, y)); // Добавляем точку справа
                    point.add(new Point(x - 1, y)); // Добавляем точку слева
                    point.add(new Point(x, y + 1)); // Добавляем точку снизу
                    point.add(new Point(x, y - 1)); // Добавляем точку сверху
                }
            }
            canvas.setPaint(oldColor); //ставим старый цвет рисования
            repaint();  // Перерисовываем изображение
        }
    }

    public Form1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new MyPicture();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа с графикой в Java");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(244, 243, 234));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 290, 240);

        setSize(new java.awt.Dimension(296, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
