package com.ext.portlet.halcon.dto;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.SimuladoresUtil;

public class SolicitudProductoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Campos en formulario 1
	private Integer	 id;
	private String 	 idTipoDocumento;
	private Integer	 idTipoDocumentoAqd;
	private String 	 numeroDocumento;
	private String 	 apellidoPaterno;
	private String 	 apellidoMaterno;
	private String 	 primerNombre;
	private String 	 segundoNombre;
	private String 	 fechaNacimiento;
	private String 	 tipoSexo;
	private String   idEstadoCivil;
	private Integer	 idEstadoCivilAdq;
	private String 	 estadoCivil;
	private String 	 situacionLaboral;
	private String	 idSituacionLaboral;
	private String 	 ruc;
	private String 	 rentaMensual;
	
	//Campos en formulario 2
	private String 	 departamento;
	private String 	 idDepartamento;
	private String 	 provincia;
	private String	 idProvincia;
	private String   distrito;
	private String   idDistrito;
	private String   direccionEnvio;
	private String 	 horarioEnvio;
	private String   placaVehiculo;
	private String 	 celular;
	private String 	 telefonoCasa;
	private String 	 telefonoTrabajo;
	private String 	 anexo;
	private String 	 email;
	
	//Campos adicionales
	private String 	 fechaRegistro;
	private String 	 idProducto;
	private String 	 producto;
	private String	 utmSource;
	private String 	 utmMedium;
	private String 	 utmCampaing;
	private String 	 utmContent;
	
	private Boolean  estadoPaso1Credito;
	private Boolean  estadoPaso2Credito;
	
	private Boolean  estadoPaso1Vehicular;
	private Boolean  estadoPaso2Vehicular;
	
	private Boolean  estadoPaso1Hipotecario;
	private Boolean  estadoPaso2Hipotecario;
	
	private Boolean  estadoPaso1Personal;
	private Boolean  estadoPaso2Personal;
	
	private Boolean  estadoPaso1Mutuos;
	private Boolean  estadoPaso2Mutuos;
	
	private Boolean  estadoPaso1Sueldo;
	private Boolean  estadoPaso2Sueldo;
	
	private Boolean  estadoPaso1Soat;
	private Boolean  estadoPaso2soat;
	
	private Boolean  estadoPaso1Aprobado;
	private Boolean  estadoPaso2Aprobado;
	
	
	//******Adicionado por Juan *******
	private Integer  tipoCredito;
	private String  codigoCanal;
	private Integer  tipoEnvio;
	private List <ProductoComplementarioBean> productoComplementarios;
	private String respuestaPreCalificacion;
	
//	private String 	 comentario;
	private String 	 codigoCampana;
	private String 	 montoProspectado;
	private String 	 codigoMoneda;
	
	private List <TelefonoLeadBean> telefonoLeads;
	
	//**********************************
	
	//******Adicionado por Ronald *******
	private String razonSocial;
	//Datos de los servicio
	private Boolean estadoPreCalificacion;
	private Boolean estadoRegLead;
	private Boolean estadoEnvCorreo;
	private String fechaResultadoPreCalif;
	private String fechaEnvioLead;
	private String fechaEnvioEmailing;
	//**********************************
	private String monto;
	private String etiqueta;
	private String siebel;
	private String respRegLead;
	
	private String responsableAsignacion;
	private Integer indicadorMailing;
	
	
	public SolicitudProductoBean() {
		inicializarSolicitud();
	}
	
	public Integer getId() {
		return id;
	}

	public void inicializarSolicitud() {
		this.id = 0;
		this.idTipoDocumento = "";
		this.idTipoDocumentoAqd = 0;
		this.numeroDocumento = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.primerNombre = "";
		this.segundoNombre = "";
		this.fechaNacimiento = "";
		this.tipoSexo = "";
		this.idEstadoCivil = "";
		this.idEstadoCivilAdq = 0;
		this.estadoCivil = "";
		this.situacionLaboral = "";
		this.idSituacionLaboral = "";
		this.ruc = "";
		this.rentaMensual = "";
		this.departamento = "";
		this.idDepartamento = "";
		this.provincia = "";
		this.idProvincia = "";
		this.distrito = "";
		this.idDistrito = "";
		this.direccionEnvio = "";
		this.horarioEnvio = "";
		this.placaVehiculo = "";
		this.celular = "";
		this.telefonoCasa = "";
		this.telefonoTrabajo = "";
		this.anexo = "";
		this.email = "";
		this.fechaRegistro = "";
		this.idProducto = "";
		this.producto = "";
		this.utmSource = "";
		this.utmMedium = "";
		this.utmCampaing = "";
		this.utmContent = "";
		this.estadoPaso1Credito = false;
		this.estadoPaso2Credito = false;
		this.estadoPaso1Vehicular = false;
		this.estadoPaso2Vehicular = false;
		this.estadoPaso1Hipotecario = false;
		this.estadoPaso2Hipotecario = false;
		this.estadoPaso1Personal = false;
		this.estadoPaso2Personal = false;
		this.estadoPaso1Mutuos = false;
		this.estadoPaso2Mutuos = false;
		this.estadoPaso1Sueldo = false;
		this.estadoPaso2Sueldo = false;
		this.estadoPaso1Soat = false;
		this.estadoPaso2soat = false;
		this.estadoPaso1Aprobado = false;
		this.estadoPaso2Aprobado = false;
		this.tipoCredito = 0;
		this.codigoCanal = String.valueOf(SimuladoresUtil.CODIGO_CANAL);
		this.tipoEnvio = Integer.valueOf(Propiedades.getResourceBundle("tipo.envio.lead"));
		this.productoComplementarios = new ArrayList<ProductoComplementarioBean>();
		this.respuestaPreCalificacion = "";
		this.codigoCampana = "";
		this.montoProspectado = "";
		this.codigoMoneda = "";
		this.razonSocial = "";
		this.estadoPreCalificacion = false;
		this.estadoRegLead = false;
		this.estadoEnvCorreo = false;
		this.fechaResultadoPreCalif = "";
		this.fechaEnvioLead = "";
		this.fechaEnvioEmailing = "";
		this.monto = "";
		this.etiqueta = "";
		this.siebel = "";
		this.respRegLead = "";
		this.responsableAsignacion = "";
		this.telefonoLeads = new ArrayList<TelefonoLeadBean>();
		this.indicadorMailing = 0;
    }

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getIndicadorMailing() {
		return indicadorMailing;
	}

	public void setIndicadorMailing(Integer indicadorMailing) {
		this.indicadorMailing = indicadorMailing;
	}
	
	public Integer getIdTipoDocumentoAqd() {
		return idTipoDocumentoAqd;
	}

	public void setIdTipoDocumentoAqd(Integer idTipoDocumentoAqd) {
		this.idTipoDocumentoAqd = idTipoDocumentoAqd;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(String tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
	

	public String getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(String idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public Integer getIdEstadoCivilAdq() {
		return idEstadoCivilAdq;
	}

	public void setIdEstadoCivilAdq(Integer idEstadoCivilAdq) {
		this.idEstadoCivilAdq = idEstadoCivilAdq;
	}

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public String getIdSituacionLaboral() {
		return idSituacionLaboral;
	}

	public void setIdSituacionLaboral(String idSituacionLaboral) {
		this.idSituacionLaboral = idSituacionLaboral;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRentaMensual() {
		return rentaMensual;
	}

	public void setRentaMensual(String rentaMensual) {
		this.rentaMensual = rentaMensual;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getHorarioEnvio() {
		return horarioEnvio;
	}

	public void setHorarioEnvio(String horarioEnvio) {
		this.horarioEnvio = horarioEnvio;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
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

	public Boolean getEstadoPaso1Credito() {
		return estadoPaso1Credito;
	}

	public void setEstadoPaso1Credito(Boolean estadoPaso1Credito) {
		this.estadoPaso1Credito = estadoPaso1Credito;
	}

	public Boolean getEstadoPaso2Credito() {
		return estadoPaso2Credito;
	}

	public void setEstadoPaso2Credito(Boolean estadoPaso2Credito) {
		this.estadoPaso2Credito = estadoPaso2Credito;
	}

	public Boolean getEstadoPaso1Vehicular() {
		return estadoPaso1Vehicular;
	}

	public void setEstadoPaso1Vehicular(Boolean estadoPaso1Vehicular) {
		this.estadoPaso1Vehicular = estadoPaso1Vehicular;
	}

	public Boolean getEstadoPaso2Vehicular() {
		return estadoPaso2Vehicular;
	}

	public void setEstadoPaso2Vehicular(Boolean estadoPaso2Vehicular) {
		this.estadoPaso2Vehicular = estadoPaso2Vehicular;
	}

	public Boolean getEstadoPaso1Hipotecario() {
		return estadoPaso1Hipotecario;
	}

	public void setEstadoPaso1Hipotecario(Boolean estadoPaso1Hipotecario) {
		this.estadoPaso1Hipotecario = estadoPaso1Hipotecario;
	}

	public Boolean getEstadoPaso2Hipotecario() {
		return estadoPaso2Hipotecario;
	}

	public void setEstadoPaso2Hipotecario(Boolean estadoPaso2Hipotecario) {
		this.estadoPaso2Hipotecario = estadoPaso2Hipotecario;
	}

	public Boolean getEstadoPaso1Personal() {
		return estadoPaso1Personal;
	}

	public void setEstadoPaso1Personal(Boolean estadoPaso1Personal) {
		this.estadoPaso1Personal = estadoPaso1Personal;
	}

	public Boolean getEstadoPaso2Personal() {
		return estadoPaso2Personal;
	}

	public void setEstadoPaso2Personal(Boolean estadoPaso2Personal) {
		this.estadoPaso2Personal = estadoPaso2Personal;
	}

	public Boolean getEstadoPaso1Mutuos() {
		return estadoPaso1Mutuos;
	}

	public void setEstadoPaso1Mutuos(Boolean estadoPaso1Mutuos) {
		this.estadoPaso1Mutuos = estadoPaso1Mutuos;
	}

	public Boolean getEstadoPaso2Mutuos() {
		return estadoPaso2Mutuos;
	}

	public void setEstadoPaso2Mutuos(Boolean estadoPaso2Mutuos) {
		this.estadoPaso2Mutuos = estadoPaso2Mutuos;
	}

	public Boolean getEstadoPaso1Sueldo() {
		return estadoPaso1Sueldo;
	}

	public void setEstadoPaso1Sueldo(Boolean estadoPaso1Sueldo) {
		this.estadoPaso1Sueldo = estadoPaso1Sueldo;
	}

	public Boolean getEstadoPaso2Sueldo() {
		return estadoPaso2Sueldo;
	}

	public void setEstadoPaso2Sueldo(Boolean estadoPaso2Sueldo) {
		this.estadoPaso2Sueldo = estadoPaso2Sueldo;
	}

	public Boolean getEstadoPaso1Soat() {
		return estadoPaso1Soat;
	}

	public void setEstadoPaso1Soat(Boolean estadoPaso1Soat) {
		this.estadoPaso1Soat = estadoPaso1Soat;
	}

	public Boolean getEstadoPaso2soat() {
		return estadoPaso2soat;
	}

	public void setEstadoPaso2soat(Boolean estadoPaso2soat) {
		this.estadoPaso2soat = estadoPaso2soat;
	}

	public Boolean getEstadoPaso1Aprobado() {
		return estadoPaso1Aprobado;
	}

	public void setEstadoPaso1Aprobado(Boolean estadoPaso1Aprobado) {
		this.estadoPaso1Aprobado = estadoPaso1Aprobado;
	}

	public Boolean getEstadoPaso2Aprobado() {
		return estadoPaso2Aprobado;
	}

	public void setEstadoPaso2Aprobado(Boolean estadoPaso2Aprobado) {
		this.estadoPaso2Aprobado = estadoPaso2Aprobado;
	}

	//**********Adicionado por Juan*************************
	public Integer getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(Integer tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	

	//*********************************
	
	//**********Adicionado por Ronald*************************
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public boolean isEstadoPreCalificacion() {
		return estadoPreCalificacion;
	}

	public void setEstadoPreCalificacion(boolean estadoPreCalificacion) {
		this.estadoPreCalificacion = estadoPreCalificacion;
	}

	public boolean isEstadoRegLead() {
		return estadoRegLead;
	}

	public void setEstadoRegLead(boolean estadoRegLead) {
		this.estadoRegLead = estadoRegLead;
	}

	public boolean isEstadoEnvCorreo() {
		return estadoEnvCorreo;
	}

	public void setEstadoEnvCorreo(boolean estadoEnvCorreo) {
		this.estadoEnvCorreo = estadoEnvCorreo;
	}

	public String getFechaResultadoPreCalif() {
		return fechaResultadoPreCalif;
	}

	public void setFechaResultadoPreCalif(String fechaResultadoPreCalif) {
		this.fechaResultadoPreCalif = fechaResultadoPreCalif;
	}

	public String getFechaEnvioLead() {
		return fechaEnvioLead;
	}

	public void setFechaEnvioLead(String fechaEnvioLead) {
		this.fechaEnvioLead = fechaEnvioLead;
	}

	public String getFechaEnvioEmailing() {
		return fechaEnvioEmailing;
	}

	public void setFechaEnvioEmailing(String fechaEnvioEmailing) {
		this.fechaEnvioEmailing = fechaEnvioEmailing;
	}
	
	//*********************************
	
	public String getInfo(){
		StringBuilder builder = new StringBuilder();
		Field[] fields = SolicitudProductoBean.class.getDeclaredFields();
			try {
				for (Field field : fields) {
				builder.append(field.getName()+" = "+SolicitudProductoBean.class.getDeclaredField(field.getName()).get(this));
				builder.append("\t  ");
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		
		return builder.toString();
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public List<ProductoComplementarioBean> getProductoComplementarios() {
		return productoComplementarios;
	}

	public void setProductoComplementarios(List<ProductoComplementarioBean> productoComplementarios) {
		this.productoComplementarios = productoComplementarios;
	}

	public String getRespuestaPreCalificacion() {
		return respuestaPreCalificacion;
	}

	public void setRespuestaPreCalificacion(String respuestaPreCalificacion) {
		this.respuestaPreCalificacion = respuestaPreCalificacion;
	}

	public List<TelefonoLeadBean> getTelefonoLeads() {
		return telefonoLeads;
	}

	public void setTelefonoLeads(List<TelefonoLeadBean> telefonoLeads) {
		this.telefonoLeads = telefonoLeads;
	}

	public String getCodigoCanal() {
		return codigoCanal;
	}

	public void setCodigoCanal(String codigoCanal) {
		this.codigoCanal = codigoCanal;
	}

	public Integer getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(Integer tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public String getCodigoCampana() {
		return codigoCampana;
	}

	public void setCodigoCampana(String codigoCampana) {
		this.codigoCampana = codigoCampana;
	}

	public String getMontoProspectado() {
		return montoProspectado;
	}

	public void setMontoProspectado(String montoProspectado) {
		this.montoProspectado = montoProspectado;
	}

	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getSiebel() {
		return siebel;
	}

	public void setSiebel(String siebel) {
		this.siebel = siebel;
	}

	public String getResponsableAsignacion() {
		return responsableAsignacion;
	}

	public void setResponsableAsignacion(String responsableAsignacion) {
		this.responsableAsignacion = responsableAsignacion;
	}

	public String getRespRegLead() {
		return respRegLead;
	}

	public void setRespRegLead(String respRegLead) {
		this.respRegLead = respRegLead;
	}
	
	
	
}
