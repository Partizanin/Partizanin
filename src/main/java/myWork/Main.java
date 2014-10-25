package myWork;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 30.08.2014
 * Time:  8:46
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    /*public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Prime Numbers Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        PrimeNumbersTask task = new PrimeNumbersTask(textArea, 10000);
        final JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true);
        frame.add(progressBar, BorderLayout.NORTH);

        frame.setSize(500, 500);
        frame.setVisible(true);

        task.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public  void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equals(evt.getPropertyName())) {
                            progressBar.setIndeterminate(false);
                            progressBar.setValue((Integer)evt.getNewValue());
                        }
                    }
                });
        task.execute();

        return;
    }*/

    public static void main(String[] args) {

        String s = "01";

        System.out.println(s.substring(0, 1));
    }


    /**
     * Finds first N prime numbers.
     */
    static class PrimeNumbersTask extends SwingWorker<java.util.List<Integer>, Integer> {
        final int numbersToFind;
        //sorted list of consequent prime numbers
        private final java.util.List<Integer> primeNumbers;
        private final JTextArea textArea;

        PrimeNumbersTask(JTextArea textArea, int numbersToFind) {
            this.textArea = textArea;
            this.numbersToFind = numbersToFind;
            this.primeNumbers = new ArrayList<Integer>(numbersToFind);
        }

        @Override
        public java.util.List<Integer> doInBackground() {
            int number = 2;
            while (primeNumbers.size() < numbersToFind
                    && !isCancelled()) {
                if (isPrime(number)) {
                    primeNumbers.add(number);
                    setProgress(100 * primeNumbers.size() / numbersToFind);
                    publish(number);
                }
                number++;
            }
            return primeNumbers;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            StringBuilder strBuilder = new StringBuilder();
            for (int number : chunks) {
                strBuilder.append(number).append('\n');
            }
            textArea.append(strBuilder.toString());
        }

        private boolean isPrime(int number) {
            for (int prime : primeNumbers) {
                if (number % prime == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
