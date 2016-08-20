package me.champeau.groovydroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public final class GroovyActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groovy_main);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.groovy, menu);
        return true;
    }

    public void executeCode(View view) {
        EditText resultView = (EditText) findViewById(R.id.resultView);
        resultView.setText(generateMessage());
    }

    private String generateMessage() {
        GrooidShell shell = new GrooidShell(getApplicationContext().getDir("dynclasses", 0), this.getClassLoader());

        EditText code = (EditText) findViewById(R.id.editText);
        GrooidShell.EvalResult evaluate = shell.evaluate(code.getText().toString());
        return evaluate.toString();
    }

}
