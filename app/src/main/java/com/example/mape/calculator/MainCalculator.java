package com.example.mape.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.mape.calculadora.R;
import java.util.Stack;


public class MainCalculator extends AppCompatActivity {

    private Stack<Double> numbers =new Stack<>();
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        text = (TextView) findViewById(R.id.textView);

        ////numbers
        findViewById(R.id.button_cero).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(0.0);
            }
        });

        findViewById(R.id.button_one).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(1.0);
            }
        });

        findViewById(R.id.button_two).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(2.0);
            }
        });

        findViewById(R.id.button_three).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(3.0);
            }
        });

        findViewById(R.id.button_four).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(4.0);
            }
        });

        findViewById(R.id.button_five).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(5.0);
            }
        });

        findViewById(R.id.button_six).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(6.0);
            }
        });

        findViewById(R.id.button_seven).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(7.0);
            }
        });

        findViewById(R.id.button_eight).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumbers(8.0);
            }
        });


        findViewById(R.id.button_nine).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setNumbers(9.0);
            }
        });

    }

    public void sum(View view){
        calculationOperations("+");
    }

    public void division(View view){
        calculationOperations("/");
    }

    public void multiplication(View view){
        calculationOperations("*");
    }

    public void subst(View view){
        calculationOperations("-");
    }

    public void tan(View view){
        calculationOperations("tan");
    }

    public void cos(View view){
        calculationOperations("cos");
    }

    public void sin(View view){
        calculationOperations("sin");
    }

    public void signs(View view){
        calculationOperations("signs");
    }

    public void percentage (View view){
        calculationOperations("percentage");
    }

    public void inverse(View view){
        calculationOperations("inverse");
    }

    public void absoluteValue(View view){
        calculationOperations("absoluteValue");
    }

    public void clear(View view){
        numbers.clear();
        text.setText("0");
    }
    public void setNumbers(double number){

        if(numbers.size()==0){
            numbers.push(number);
            text.setText(numbers.get(0)+"");
        }
        else if(numbers.size()==1){
            numbers.push(number);
            text.setText(numbers.get(0)+" "+numbers.get(1));

        }else text.setText("Error");
    }

    public void calculationOperations(String operation){
        double num1;
        double num2;

        if(numbers.size()==1 && !(operation=="+") && !(operation=="-") && !(operation=="*") && !(operation=="/")){
            num1= numbers.pop();

            if(operation=="sin"){
                numbers.push(Math.sin(Math.toDegrees(num1)));
            }
            if(operation=="cos"){
                numbers.push(Math.cos(Math.toDegrees(num1)));
            }
            if(operation=="tan"){
                numbers.push(Math.tan(Math.toDegrees(num1)));
            }
            if(operation=="signs"){
                numbers.push(num1*(-1));
            }
            if(operation=="percentage"){
                numbers.push(num1*100);
            }
            if(operation=="inverse"){
                numbers.push(1/num1);
            }
            if(operation=="absoluteValue"){
                numbers.push(Math.abs(num1));
            }
            text.setText(""+ String.format("%.4f", numbers.peek()));
        }
        else if(numbers.size()==2 && !(operation=="tan")&& !(operation=="sin")&& !(operation=="cos")&& !(operation=="signs")&& !(operation=="inverse")){
            num1= numbers.pop();
            num2= numbers.pop();

            if(operation=="+"){
                numbers.push(num2+num1);
            }
            else if(operation=="-"){
                numbers.push(num2-num1);
            }
            else if(operation=="*"){
                numbers.push(num2*num1);
            }
            else if(operation=="/"){
                numbers.push(num2/num1);
            }
            text.setText(""+ String.format("%.4f", numbers.peek()));
            }
        else{
            text.setText("Error");
        }

    }
}
