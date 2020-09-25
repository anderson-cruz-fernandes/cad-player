package br.com.sons_cad2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Cad_Player extends ListActivity {
	
	private MediaPlayer mMediaPlayer = new MediaPlayer();
	private Integer[] sons_id = {
			R.raw.afranio_docx_nao,
			R.raw.ahh,
			R.raw.alguem_vai_precisar_de_mim,
			R.raw.antigos_espiritos,
			R.raw.aqui_tem_maionese,
			R.raw.arquivo_boa_tarde,
			R.raw.arroto,
			R.raw.deadpeople,
			R.raw.e_o_caldinho,
			R.raw.e_o_casamento,
			R.raw.e_os_salgadinhos,
			R.raw.e_por_hoje_2,
			R.raw.e_ruim_de_nao,
			R.raw.esse_tal_de_pdf_eh_muito_interessante2,
			R.raw.maiores_informacoes_sobre_pdf2,
			R.raw.mumm_ra_idiotas,
			R.raw.padre_quevedo_iczto_non_ecziste,
			R.raw.pay_to_vacile_inocente,
			R.raw.po_mo_palha_inocente,
			R.raw.quem_eh_danilo,
			R.raw.quiaquiaquia,
			R.raw.rabugento,
			R.raw.rebobinando_a_fita,
			R.raw.risada_mais_escrota_possivel,
			R.raw.so_se_eu_tivesse_doido,
			R.raw.ta_com_dinheiro,
			R.raw.ta_daonde_daonde,
			R.raw.tem_perigo_nao,
			R.raw.todos_idiotas,
			R.raw.unhhh_sei_nao
	};
 	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        List<String> nomeArquivos = listRaw();
        ArrayAdapter<String> arquivos = 
        		new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomeArquivos);
          
        setListAdapter(arquivos);       
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	    	   	
        mMediaPlayer = MediaPlayer.create(this, sons_id[position]);
        if (mMediaPlayer != null){
        	mMediaPlayer.start();       	
        }else{
        	Toast.makeText(this, "Ocorreu um erro ao tentar reproduzir o arquivo!", Toast.LENGTH_SHORT).show();
        }
    }
    
    private List<String> listRaw(){
        Field[] fields=R.raw.class.getFields();
        List<String> nomeArquivos = new ArrayList<String>();
        for(int count=0; count < fields.length; count++){
        	nomeArquivos.add(fields[count].getName());
        }
        
        return nomeArquivos;
    }    
}
