package br.com.florenciof.projetofinal.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.florenciof.projetofinal.dao.EventoDAO;
import br.com.florenciof.projetofinal.dto.PeriodoConsulta;
import br.com.florenciof.projetofinal.dto.VolumeAlarmes;
import br.com.florenciof.projetofinal.model.Evento;

@RestController
@CrossOrigin("*")
public class EventoController {

	@Autowired
	private EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> eventos(){
		return (ArrayList<Evento>)dao.findByOrderByData();
	}
	
	@GetMapping("/eventos/relatorios/alarmes")
	public ArrayList<VolumeAlarmes> relatorioAlarmes(){
		return (ArrayList<VolumeAlarmes>)dao.getAllWithName();	
	}
	
	
	@PostMapping("/eventos/periodo")
	public ArrayList<Evento> recuperarPorPeriodo(@RequestBody PeriodoConsulta periodo){
		try {
			Date inicio = new SimpleDateFormat("yyyy-MM-dd").parse(periodo.getInicio());
			Date fim = new SimpleDateFormat("yyyy-MM-dd").parse(periodo.getFim());
			return (ArrayList<Evento>)dao.findByDataBetween(inicio, fim);
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	@GetMapping("/eventos/alarmes/manual")
	public ArrayList<VolumeAlarmes> recuperarEventosManual(){
		
		ArrayList<Evento> lista = (ArrayList<Evento>)dao.findAll();
		ArrayList<VolumeAlarmes> resultado = new ArrayList<VolumeAlarmes>();
		
		long failLink = 0, conecErr = 0, uploadFail = 0, abruptInt = 0, eventUnk = 0;
		
		for (Evento ev: lista) {
			switch (ev.getAlarme().getId()) {
			case 1: //Fail link
				failLink ++;
				break;
			case 2: //CONECTOR_ERR
				conecErr ++;
				break;
			case 3: //UPLOAD_FAIL
				uploadFail ++;
				break;
			case 4: //Abrupt Interruption
				abruptInt ++;
				break;
			case 5: //Event Unknown
				eventUnk ++;
				break;
			}
		}
		
		resultado.add(new VolumeAlarmes(1, "Fail Link", failLink));
		resultado.add(new VolumeAlarmes(2, "Conector Err", conecErr));
		resultado.add(new VolumeAlarmes(3, "Upload Fail", uploadFail));
		resultado.add(new VolumeAlarmes(4, "Abrupt Interrupt", abruptInt));
		resultado.add(new VolumeAlarmes(5, "Event Unknown", eventUnk));
		
		return resultado;
	}
		
	
	
	
}
