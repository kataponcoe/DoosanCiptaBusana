package id.kataponcoe.doosanciptabusana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity
{
	EditText ubahNamaPengguna,ubahKataSandi,ubahKonfirmasiKataSandi;
	Button buatAkun;
	
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.daftar);
		
		// get Instance  of Database Adapter
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		// Get Refferences of Views
		ubahNamaPengguna=(EditText)findViewById(R.id.editNamaPengguna);
		ubahKataSandi=(EditText)findViewById(R.id.editKataSandi);
		ubahKonfirmasiKataSandi=(EditText)findViewById(R.id.editKonfirmasiKataSandi);
		
		buatAkun=(Button)findViewById(R.id.btnBuatAkun);
		buatAkun.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String userName=ubahNamaPengguna.getText().toString();
			String password=ubahKataSandi.getText().toString();
			String confirmPassword=ubahKonfirmasiKataSandi.getText().toString();
			
			// check if any of the fields are vacant
			if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Mohon Diisi Nama Pengguna dan Sandi!", Toast.LENGTH_LONG).show();
					return;
			}
			// check if both password matches
			if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Kata Sandi tidak sesuai!", Toast.LENGTH_LONG).show();
				return;
			}
			else
			{
			    // Save the Data in Database
			    loginDataBaseAdapter.insertEntry(userName, password);
			    startActivity(new Intent(SignUPActivity.this, MenuLogin.class));
			} 
			    Toast.makeText(getApplicationContext(), "Selamat! Pembuatan Akun sudah Berhasil, Silahkan Login! ", Toast.LENGTH_LONG).show();
			}
			
		});
	};

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		loginDataBaseAdapter.close();
	}
}
