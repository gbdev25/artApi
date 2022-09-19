package com.revature.facepaint.controllers;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArtController {
	
	public ArtController() {
		super();
	}
	
	
	//retrieve art by id
	@GetMapping(value = "/artId", produces = "application/json")
    public ResponseEntity getArtAttributes(@RequestParam(name="artId") String id){
		String urlFront = "https://api.artic.edu/api/v1/artworks/";
		String url = urlFront+id;
		RestTemplate restTemplate = new RestTemplate();

		String artAttr = restTemplate.getForObject(url, String.class);
		return new ResponseEntity(artAttr, HttpStatus.OK);
	}
	
	
	
	//retrieve search results
	@GetMapping(value = "/search", produces = "application/json")
    public ResponseEntity searchAPI(@RequestParam(name="query") String query){
		String urlFront = "https://api.artic.edu/api/v1/artworks/search?q=";
		String urlBack = "[term][is_on_view]=true";
		String url = urlFront+query+urlBack;
		
		RestTemplate restTemplate = new RestTemplate();

		String searchRet = restTemplate.getForObject(url, String.class);
		return new ResponseEntity(searchRet, HttpStatus.OK);
	}
	
	@GetMapping(value = "/artwork")//, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getArtPiece(@RequestParam(name="imageID") String imageID){
		String urlFront = "https://www.artic.edu/iiif/2/";
		String urlBack = "/full/843,/0/default.jpg";
		String url = urlFront+imageID+urlBack;
		RestTemplate restTemplate = new RestTemplate();
		byte[] artPiece = restTemplate.getForObject(url, byte[].class);
		return new ResponseEntity<byte[]>(artPiece, HttpStatus.OK);
	}
    
    
	/*//retrieve picture of art
	@GetMapping(value = "/showArt")
    public ResponseEntity<byte[]> getArtPiece(@RequestParam(name="imageId") String imageId){
		String urlFront = "https://www.artic.edu/iiif/2/";
		String urlBack = "/full/843,/0/default.jpg";
		String url = urlFront+imageId+urlBack;
		RestTemplate restTemplate = new RestTemplate();

		byte[] artPiece = restTemplate.getForObject(url, byte[].class);
		return new ResponseEntity<byte[]>(artPiece, HttpStatus.OK);
	}*/
}
