package com.usach.AGUILA_COMEX_be;

import com.usach.AGUILA_COMEX_be.entities.OperationNumberEntity;
import com.usach.AGUILA_COMEX_be.repositories.OperationNumberRepository;
import com.usach.AGUILA_COMEX_be.repositories.PortsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class AguilaComexBeApplication {

	@Autowired
	private OperationNumberRepository operationNumberRepository;

	@Autowired
	private PortsRepository portsRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AguilaComexBeApplication.class, args);
	}

	@Transactional
	@PostConstruct
	public void initOperationNumber(){
		if (operationNumberRepository.count()==0){
			operationNumberRepository.resetID();
			OperationNumberEntity operationNumberEntity = new OperationNumberEntity();
			operationNumberEntity.setCurrent_operation_number(2);
			operationNumberRepository.save(operationNumberEntity);
		}
	}

	@Transactional
	@PostConstruct
	public void initPorts(){
		if (portsRepository.count()==0){
			String insertPorts = "INSERT INTO ports" +
					"(code, country, name)" +
					"VALUES('ARBUE','BUENOS AIRES','ARGENTINA')," +
					"('BRSSZ','SANTOS','BRASIL')," +
					"('CLANF','ANTOFAGASTA','CHILE')," +
					"('CLARI','ARICA','CHILE')," +
					"('CLCNL','CORONEL','CHILE')," +
					"('CLLQN','LIRQUEN','CHILE')," +
					"('CLVALP','VALPARAISO','CHILE')," +
					"('CLIQQ','IQUIQUE','CHILE')," +
					"('CLANG','ANGAMOS','CHILE')," +
					"('CLSAI','SAN ANTONIO','CHILE')," +
					"('CLSVE','SAN VICENTE','CHILE')," +
					"('COBUN','BUENAVENTURA','COLOMBIA')," +
					"('COCTG','CARTAGENA','COLOMBIA')," +
					"('ECGYE','GUAYAQUIL','ECUADOR')," +
					"('SVAQJ','ACAJUTLA','EL SALVADOR')," +
					"('USBAL','BALTIMORE','ESTADOS UNIDOS')," +
					"('USFL4','LOS ANGELES','ESTADOS UNIDOS')," +
					"('USLAX','LOS ANGELES','ESTADOS UNIDOS')," +
					"('USLGB','LONG BEACH','ESTADOS UNIDOS')," +
					"('USNYC','NEW YORK','ESTADOS UNIDOS')," +
					"('JMKIN','KINGSTON','JAMAICA')," +
					"('MXLZC','LAZARO CARDENAS','MEXICO')," +
					"('MXVER','VERACRUZ','MEXICO')," +
					"('MXZLO','MANZANILLO','MEXICO')," +
					"('PABLB','BALBOA','PANAMA')," +
					"('PECLL','CALLAO','PERU')," +
					"('DOCAU','CAUCEDO','REP. DOMINICANA')," +
					"('VELAG','LA GUAIRA','VENEZUELA')," +
					"('DEHAM','HAMBURGO','ALEMANIA')," +
					"('BEANR','AMBERES','BELGICA')," +
					"('ESALG','ALGECIRAS','ESPAÑA')," +
					"('ESVLC','VALENCIA','ESPAÑA')," +
					"('NLRTM','ROTTERDAM','PAISES BAJOS')," +
					"('PTLIS','LISBOA','PORTUGAL')," +
					"('TRIST','ISTAMBUL','TURQUIA')," +
					"('AUMEL','MELBOURNE','AUSTRALIA')," +
					"('CNNBO','NINGBO','CHINA')," +
					"('CNSHK','SHEKOU','CHINA')," +
					"('CNSNZ','SHENZHEN','CHINA')," +
					"('KRPUS','BUSAN','COREA DEL SUR')," +
					"('MYNTL','PENANG','MALASIA');";
			jdbcTemplate.update(insertPorts);
		}
	}
}
