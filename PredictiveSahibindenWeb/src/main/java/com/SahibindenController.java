package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="sahibindenController")
@SessionScoped
public class SahibindenController {

	private String sehir="Istanbul";
	private String ilce="Cekmekoy";
	private String mahalle="Alemdag Mah.";
	
	private String yil="2014";
	private String m2="149";
	private String odaSayisi="7";
	private String banyoSayisi="2";
	private String binaYasi="7";
	private String binaKatSayisi="4";
	private String bulunduguKat="1";
	
	private String isitma;
	private String kullanimDurumu;
	private String krediyeUygunMu;
	private String kimden;
	private String takas;
	
	private String result ;
	
	private List<Model> dataset = new ArrayList<Model>();
	
	
	public String predict(){
		try {
			System.out.println("test");
			List<Object> list = new ArrayList<Object>();
			list.add(sehir);
			list.add(ilce);
			list.add(mahalle);
			//list.add(new Long(0)); //ilan no;
			list.add(new Long(yil));
			//list.add(""); //emlak tipi
			list.add(new Long(m2));
			list.add(new Long(odaSayisi));
			list.add(new Long(banyoSayisi));
			list.add(new Long(binaYasi));
			list.add(new Long(binaKatSayisi));
			list.add(new Long(bulunduguKat));
			list.add(isitma);
			list.add(kullanimDurumu);
			list.add(krediyeUygunMu);
			list.add(kimden);
			list.add(takas);
			
			
			result = PredictionSahibinden.makePrediction(list);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
		}
		return "";
	}

	
	
	
	
	public String showDataSet(){
		//InputStream  IS = ClassLoader.getSystemResourceAsStream("/sahibinden_database.txt");
		
		dataset.clear();
		String csvFile = "D:/calismalar/gurkan/PredictiveSahibindenWeb/src/main/resources/sahibinden_database_new.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				Model model = new Model();
				String[] data = line.split(cvsSplitBy);
	 
				model.setFiyat(data[0]);
				model.setSehir(data[1]);
				model.setIlce(data[2]);
				model.setMahalle(data[3]);
				model.setYil(data[4]);
				model.setM2(data[5]);
				model.setOdaSayisi(data[6]);
				model.setBanyoSayisi(data[7]);
				model.setBinaYasi(data[8]);
				model.setBinaKatSayisi(data[9]);
				model.setBulunduguKat(data[10]);
				model.setIsitma(data[11]);
				model.setKullanimDurumu(data[12]);
				model.setKrediyeUygunMu(data[13]);
				model.setKimden(data[14]);
				model.setTakas(data[15]);
				dataset.add(model);
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getSehir() {
		return sehir;
	}


	public void setSehir(String sehir) {
		this.sehir = sehir;
	}


	public String getIlce() {
		return ilce;
	}


	public void setIlce(String ilce) {
		this.ilce = ilce;
	}


	public String getMahalle() {
		return mahalle;
	}


	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}


	public String getYil() {
		return yil;
	}


	public void setYil(String yil) {
		this.yil = yil;
	}


	public String getM2() {
		return m2;
	}


	public void setM2(String m2) {
		this.m2 = m2;
	}


	public String getOdaSayisi() {
		return odaSayisi;
	}


	public void setOdaSayisi(String odaSayisi) {
		this.odaSayisi = odaSayisi;
	}


	public String getBanyoSayisi() {
		return banyoSayisi;
	}


	public void setBanyoSayisi(String banyoSayisi) {
		this.banyoSayisi = banyoSayisi;
	}


	public String getBinaYasi() {
		return binaYasi;
	}


	public void setBinaYasi(String binaYasi) {
		this.binaYasi = binaYasi;
	}


	public String getBinaKatSayisi() {
		return binaKatSayisi;
	}


	public void setBinaKatSayisi(String binaKatSayisi) {
		this.binaKatSayisi = binaKatSayisi;
	}


	public String getBulunduguKat() {
		return bulunduguKat;
	}


	public void setBulunduguKat(String bulunduguKat) {
		this.bulunduguKat = bulunduguKat;
	}


	public String getIsitma() {
		return isitma;
	}


	public void setIsitma(String isitma) {
		this.isitma = isitma;
	}


	public String getKullanimDurumu() {
		return kullanimDurumu;
	}


	public void setKullanimDurumu(String kullanimDurumu) {
		this.kullanimDurumu = kullanimDurumu;
	}


	public String getKrediyeUygunMu() {
		return krediyeUygunMu;
	}


	public void setKrediyeUygunMu(String krediyeUygunMu) {
		this.krediyeUygunMu = krediyeUygunMu;
	}


	public String getKimden() {
		return kimden;
	}


	public void setKimden(String kimden) {
		this.kimden = kimden;
	}


	public String getTakas() {
		return takas;
	}


	public void setTakas(String takas) {
		this.takas = takas;
	}




























	public String getResult() {
		return result;
	}




























	public void setResult(String result) {
		this.result = result;
	}





	public List<Model> getDataset() {
		return dataset;
	}





	public void setDataset(List<Model> dataset) {
		this.dataset = dataset;
	}
	
	
	
	
	
}
