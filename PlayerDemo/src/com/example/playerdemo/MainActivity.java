package com.example.playerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.youku.player.ApiManager;
import com.youku.player.ApiManager.ILoginState;

public class MainActivity extends Activity implements View.OnClickListener{
	Button btn_player,btn_login,btn_logout,btn_state;
	EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		init();

	}
	
	private void init(){
		btn_player = (Button)this.findViewById(R.id.btn_player);
		btn_login = (Button)this.findViewById(R.id.btn_login);
		btn_logout = (Button)this.findViewById(R.id.btn_logout);
		btn_state = (Button)this.findViewById(R.id.btn_state);
		et = (EditText)this.findViewById(R.id.vid);
		
		btn_player.setOnClickListener(this);
		btn_login.setOnClickListener(this);
		btn_logout.setOnClickListener(this);
		btn_state.setOnClickListener(this);
		
		et.setText("XNzUyMzkxMjE2");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_player:
			go2Player();
			break;
		case R.id.btn_login:
			doLogin();
			break;
		case R.id.btn_logout:
			doLogout();
			break;		
		case R.id.btn_state:
			getState();
			break;
		}
	}
	
	private void go2Player(){
		Intent i = new Intent(MainActivity.this,PlayerActivity.class);
		i.putExtra("vid", et.getText().toString().trim());
		MainActivity.this.startActivity(i);
	}
	
	private void doLogin(){
		
		ApiManager.getInstance().login();
	}
	
	private void doLogout(){
		ApiManager.getInstance().logout();
		
	}
	
	private void getState(){
		ApiManager.getInstance().getLoginState(new ILoginState() {
			
			@Override
			public void loginResult(String userName) {
				// TODO Auto-generated method stub
				Log.d("sgh","loginResult");
				String msg = "";
				if(userName.equals(""))
					msg = "没有帐号登陆";
				else
					msg = "当前登陆帐号：" + userName;
				
				Toast.makeText(getApplicationContext(), msg, 2000).show();
			}
		});
	}
}
