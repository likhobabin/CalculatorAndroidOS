package calculator.androidOS;

import android.app.Activity;
//
import android.os.Bundle;
//
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
//
import android.view.View;
//
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import calculator.androidOS.R;
//
import calculator.Expression;
//
public class Calculator extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		//
		final EditText expr_editor = (EditText)findViewById(R.id.input_proffer);
		//
		final Button[] controls = {
				(Button)findViewById(R.id.btn_0),
				(Button)findViewById(R.id.btn_1),
				(Button)findViewById(R.id.btn_2),
				(Button)findViewById(R.id.btn_3),
				(Button)findViewById(R.id.btn_4),
				(Button)findViewById(R.id.btn_5),
				(Button)findViewById(R.id.btn_6),
				(Button)findViewById(R.id.btn_7),
				(Button)findViewById(R.id.btn_8),
				(Button)findViewById(R.id.btn_9),
				(Button)findViewById(R.id.btn_lb),//10
				(Button)findViewById(R.id.btn_rb),//11
				(Button)findViewById(R.id.btn_spot),//12
				(Button)findViewById(R.id.btn_posit),//13
				(Button)findViewById(R.id.btn_neg),//14
				(Button)findViewById(R.id.btn_mul),//15
				(Button)findViewById(R.id.btn_div),//16
				(Button)findViewById(R.id.btn_equal),//17
				(Button)findViewById(R.id.btn_lturn),//18
				(Button)findViewById(R.id.btn_clear)//19				
		};
		//
		AdapterView.OnClickListener controls_list = new AdapterView.OnClickListener(){
	         @Override
	         public void onClick(View __view)
	         {
	        	Button c_button = (Button)__view;
				//
	        	if(bClean){
	        		bClean = false;
	        		expr_editor.setText("");
	        		expr_editor.setEnabled(true);
	        	}
	        	//
	        	//'='
				if (c_button.equals(controls[17])) {
					try {
						String str_expr = expr_editor.getText().toString();
						FEvaluting.setExpression(str_expr);
						expr_editor
								.setText(String.valueOf(FEvaluting.result()));
					} catch (IllegalArgumentException ex) {
						Log.d("IllegalArgumentException",
								"Incorrect the expression", ex);
						bClean = true;
						expr_editor.setText("Incorrect the expression");
						expr_editor.setEnabled(false);
					} catch (NullPointerException ex) {
						Log.d("NullPointerException",
								"Incorrect the expression", ex);
						bClean = true;
						expr_editor.setText("Incorrect the expression");
						expr_editor.setEnabled(false);
					} catch (Exception ex) {
						Log.d("Exception", "Incorrect the expression", ex);
						bClean = true;
						expr_editor.setText("Incorrect the expression");
						expr_editor.setEnabled(false);
					}
					//
				} 
				else if (c_button.equals(controls[19])) {
					expr_editor.setText("");
				} 
				else 
					expr_editor.append(c_button.getText());
				//
			}
		};
		//
		for(Button c_btn : controls){
			c_btn.setOnClickListener(controls_list);
		}
		//      TextWatcher tw;
		TextWatcher tw = null;
		tw = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		};
		expr_editor.addTextChangedListener(tw);
    }
    //
    private Expression FEvaluting=new Expression();
    private boolean bClean = false;
}