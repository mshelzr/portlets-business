
package com.ext.portlet.halcon.dto;

import java.util.ArrayList;
import java.util.List;

import com.ext.portlet.halcon.model.FondosMutuosZonas;


public class SimuladorBean {
	/**
	 * 
	 */
	//**Credito personal**
	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoMoneda;
	private String tipoCredito;//es tipoProducto
	private String nombreCreditoProducto;
	private String plazoCredito;
	private String tipoCuota;
	//**Deposito a plazo***
	//**Fondos mutuos
	private String opcion1;
	private String opcion2;
	private String opcion3;
	private String tipoMonedaFondosMutuos;
	//**Hipotecario***
	private String valorBien;
	private String cuotaInicial;
	/*Campos Auditoria*/
	private String tipoSimulador;//El tipo de simulador
	/*Campos Auditoria*/
	private Long idSimulador = 0L;
	private String invirtioFondoMutuo;
	private String nivelConocimientoFondoMutuo;
	private String reaccionVariacionMercado;
	private String montoPrestamo;
	private String tasa;
	private String seguroDesgravamen;
	private String ip;
	private String fechaHora;
	private String utmSource;
	private String utmMedium;
	private String utmCampaing;
	private String utmContent;
	/* creado por Jaime */
	private List<FondosMutuosZonas> listFondosMutuos;
	private int totalPuntos;
	/*Valor para solicitudes*/
	private String codigoCampania;
	
	/*Para determinar si vino de fondos mutuos a deposito*/
	private boolean isFondoMutuo;
	
	public String getCodigoCampania() {
		return codigoCampania;
	}


	public void setCodigoCampania(String codigoCampania) {
		this.codigoCampania = codigoCampania;
	}


	public SimuladorBean() {
		super();
	}
	

	public SimuladorBean(SimuladorBean nuevo) {

		this.tipoDocumento = nuevo.getTipoDocumento();
		this.numeroDocumento = nuevo.getNumeroDocumento();
		this.tipoMoneda = nuevo.getTipoMoneda();
		this.tipoCredito = nuevo.getTipoCredito();
		this.plazoCredito = nuevo.getPlazoCredito();
		this.tipoCuota = nuevo.getTipoCuota();
		this.opcion1 = nuevo.getOpcion1();
		this.opcion2 = nuevo.getOpcion2();
		this.opcion3 = nuevo.getOpcion3();
		this.valorBien = nuevo.getValorBien();
		this.cuotaInicial = nuevo.getCuotaInicial();
		this.tipoSimulador = nuevo.getTipoSimulador();
		this.idSimulador = nuevo.getIdSimulador();
		this.invirtioFondoMutuo = nuevo.getInvirtioFondoMutuo();
		this.nivelConocimientoFondoMutuo = nuevo.getNivelConocimientoFondoMutuo();
		this.reaccionVariacionMercado = nuevo.getReaccionVariacionMercado();
		this.montoPrestamo = nuevo.getMontoPrestamo();
		this.tasa = nuevo.getTasa();
		this.seguroDesgravamen = nuevo.getSeguroDesgravamen();
		this.ip = nuevo.getIp();
		this.fechaHora = nuevo.getFechaHora();
		this.utmSource = nuevo.getUtmSource();
		this.utmMedium = nuevo.getUtmMedium();
		this.utmCampaing = nuevo.getUtmCampaing();
		this.utmContent = nuevo.getUtmContent();
		this.listFondosMutuos = nuevo.getListFondosMutuos();
		this.totalPuntos = nuevo.getTotalPuntos();
		this.nombreCreditoProducto = nuevo.getNombreCreditoProducto();
	}


	public void inicializarSimulador(){
		
		this.tipoDocumento = "";
		this.numeroDocumento = "";
		this.tipoMoneda = "";
		this.tipoCredito = "";
		this.plazoCredito = "";
		this.tipoCuota = "";
		this.opcion1 = "";
		this.opcion2 = "";
		this.opcion3 = "";

		this.valorBien = "";
		this.cuotaInicial = "";
		this.listFondosMutuos = new ArrayList<FondosMutuosZonas>();
		this.totalPuntos = 0; 
		
	}
	
	public int getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getPlazoCredito() {
		return plazoCredito;
	}

	public void setPlazoCredito(String plazoCredito) {
		this.plazoCredito = plazoCredito;
	}

	public String getTipoCuota() {
		return tipoCuota;
	}

	public void setTipoCuota(String tipoCuota) {
		this.tipoCuota = tipoCuota;
	}

	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}

	public String getOpcion3() {
		return opcion3;
	}

	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}

	public String getValorBien() {
		return valorBien;
	}

	public void setValorBien(String valorBien) {
		this.valorBien = valorBien;
	}

	public String getCuotaInicial() {
		return cuotaInicial;
	}

	public void setCuotaInicial(String cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public String getParametros(){
		
		return 
				this.tipoDocumento + " | " +
				this.numeroDocumento + " | " +
				this.tipoMoneda + " | " +
				this.tipoCredito + " | " +
				this.plazoCredito + " | " +
				this.tipoCuota + " | " +
				this.opcion1 + " | " +
				this.opcion2 + " | " +
				this.opcion3 + " | " +
				this.valorBien + " | " +
				this.cuotaInicial ;
		
	}
	
	public String getTipoSimulador() {
		return tipoSimulador;
	}

	public void setTipoSimulador(String tipoSimulador) {
		this.tipoSimulador = tipoSimulador;
	}

	public String getInvirtioFondoMutuo() {
		return invirtioFondoMutuo;
	}

	public void setInvirtioFondoMutuo(String invirtioFondoMutuo) {
		this.invirtioFondoMutuo = invirtioFondoMutuo;
	}

	public String getNivelConocimientoFondoMutuo() {
		return nivelConocimientoFondoMutuo;
	}

	public void setNivelConocimientoFondoMutuo(String nivelConocimientoFondoMutuo) {
		this.nivelConocimientoFondoMutuo = nivelConocimientoFondoMutuo;
	}

	public String getReaccionVariacionMercado() {
		return reaccionVariacionMercado;
	}

	public void setReaccionVariacionMercado(String reaccionVariacionMercado) {
		this.reaccionVariacionMercado = reaccionVariacionMercado;
	}

	public String getMontoPrestamo() {
		return montoPrestamo;
	}

	public void setMontoPrestamo(String montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}

	public String getTasa() {
		return tasa;
	}

	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	public String getSeguroDesgravamen() {
		return seguroDesgravamen;
	}

	public void setSeguroDesgravamen(String seguroDesgravamen) {
		this.seguroDesgravamen = seguroDesgravamen;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getUtmSource() {
		return utmSource;
	}

	public void setUtmSource(String utmSource) {
		this.utmSource = utmSource;
	}

	public String getUtmMedium() {
		return utmMedium;
	}

	public void setUtmMedium(String utmMedium) {
		this.utmMedium = utmMedium;
	}

	public String getUtmCampaing() {
		return utmCampaing;
	}

	public void setUtmCampaing(String utmCampaing) {
		this.utmCampaing = utmCampaing;
	}

	public String getUtmContent() {
		return utmContent;
	}

	public void setUtmContent(String utmContent) {
		this.utmContent = utmContent;
	}

	public Long getIdSimulador() {
		return idSimulador;
	}

	public void setIdSimulador(Long idSimulador) {
		this.idSimulador = idSimulador;
	}

	public List<FondosMutuosZonas> getListFondosMutuos() {
		return listFondosMutuos;
	}

	public void setListFondosMutuos(List<FondosMutuosZonas> listFondosMutuos) {
		this.listFondosMutuos = listFondosMutuos;
	}

	public boolean getIsFondoMutuo() {
		return isFondoMutuo;
	}

	public void setIsFondoMutuo(boolean isFondoMutuo) {
		this.isFondoMutuo = isFondoMutuo;
	}


	public String getTipoMonedaFondosMutuos() {
		return tipoMonedaFondosMutuos;
	}


	public void setTipoMonedaFondosMutuos(String tipoMonedaFondosMutuos) {
		this.tipoMonedaFondosMutuos = tipoMonedaFondosMutuos;
	}
	
	public String getNombreCreditoProducto() {
		return nombreCreditoProducto;
	}
	
	public void setNombreCreditoProducto(String nombreCreditoProducto) {
		this.nombreCreditoProducto = nombreCreditoProducto;
	}
	
}
