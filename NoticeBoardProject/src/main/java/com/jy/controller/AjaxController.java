package com.jy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;
import com.jy.service.BoardService;
import com.jy.service.CommentService;

@RestController
public class AjaxController {
    @Autowired
    BoardService bsvc;
    @Autowired
    CommentService csvc;
    
    @GetMapping(value = "/InfiniteScroller")
    public ResponseEntity<ArrayList<BoardDto>> getBoardListByPageNum(@RequestParam("pageNum") int pageNum) {
        try {
            ArrayList<BoardDto> listBoard = bsvc.getBoardListByPageNumber(pageNum);
            return new ResponseEntity<>(listBoard, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/SearchKeyword")
    public ResponseEntity<ArrayList<BoardDto>> getBoardListBySearchKeyword(@RequestParam("searchKeyword") String searchKeyword) {
        try {
            ArrayList<BoardDto> listBoard = bsvc.getBoardListBySearchKeyword(searchKeyword);
            return new ResponseEntity<>(listBoard, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @DeleteMapping(value="/{rno}", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8") 
    public ResponseEntity<String> deleteComment(@PathVariable int rno) {
        try {
            csvc.deleteComment(rno);
            return new ResponseEntity<>("댓글이 삭제되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("댓글 삭제 중 오류가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value = "/comment/modify/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> modifyComment(@RequestBody CommentDto commentDto, @PathVariable int rno) {
        try {
            csvc.updateComment(commentDto);
            String writedate = csvc.getCommentWritedateByRno(rno);
            
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("result", "5K");
            responseMap.put("writedate", writedate);
            
            return ResponseEntity.ok(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    

}
