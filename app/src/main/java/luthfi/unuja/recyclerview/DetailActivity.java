package luthfi.unuja.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {


    private ImageView ivPhoto;
    private TextView tvNama, tvDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhoto = findViewById(R.id.iv_photo);
        tvNama = findViewById(R.id.tv_nama);
        tvDetail = findViewById(R.id.tv_deskripsi);

        String nama = getIntent().getStringExtra("nama");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String foto = getIntent().getStringExtra("foto");

        tvNama.setText(nama);
        tvDetail.setText(deskripsi);
        Glide.with(DetailActivity.this)
                .load(foto)
                .into(ivPhoto);

        getSupportActionBar().setTitle(nama);
    }

}
