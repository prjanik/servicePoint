package com.app.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.entity.Point;
import com.app.crud.service.PointService;

@RestController
@RequestMapping("/api/point")
public class PointRestController {

	private PointService pointService;
	
	@Autowired
	public PointRestController(PointService pointService) {
		this.pointService = pointService;
	}
	
	@GetMapping("/points")
	public List<Point> findAll() {
		return pointService.findAll();
	}

	@GetMapping("/points/{pointId}")
	public Point getPoint(@PathVariable int pointId) {
		
		Point point = pointService.findById(pointId);
		
		if (point == null) {
			throw new RuntimeException("Point id not found - " + pointId);
		}
		
		return point;
	}
	
	@PostMapping("/points")
	public Point addPoint(@RequestBody Point point) {
		
		point.setId(0);
		
		pointService.save(point);
		
		return point;
	}
	
	
	@PutMapping("/points")
	public Point updatePoint(@RequestBody Point point) {
		
		pointService.save(point);
		
		return point;
	}
	
	
	@DeleteMapping("/points/{pointId}")
	public String deletePoint(@PathVariable int pointId) {
		
		Point point = pointService.findById(pointId);
		
		if (point == null) {
			throw new RuntimeException("Point id not found - " + pointId);
		}
		
		pointService.deleteById(pointId);
		
		return "Deleted point id - " + pointId;
	}
	
}










