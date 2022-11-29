package com.example.KTCK_Lan3_THLTDD.Controllers;

import com.example.KTCK_Lan3_THLTDD.Entities.Ca;
import com.example.KTCK_Lan3_THLTDD.Services.CaService;
import com.example.KTCK_Lan3_THLTDD.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(path = "api/ca")
public class CaController {

    @Autowired
    private CaService caService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @GetMapping("/")
    public ResponseEntity<List<Ca>> getAllItem(){
        List<Ca> caList = this.caService.getAllItem();
        return new ResponseEntity<>(caList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Ca> createItem(@RequestBody Ca ca){
        return ResponseEntity.ok(this.caService.addItem(ca));
    }

    @DeleteMapping("/{caId}")
    public ResponseEntity<String> deleteItem(@PathVariable(name = "caId") Integer id) {
        this.caService.deleteItem(id);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @PutMapping("/{caId}")
    public ResponseEntity<Ca> editItem(@RequestBody Ca ca, @PathVariable(name = "id") Integer id) {
        Ca updated = this.caService.editItem(ca, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PostMapping("/image/upload/{caId}")
    public ResponseEntity<Ca> uploadImage(@RequestParam("image") MultipartFile image,
                                                   @PathVariable Integer caId) throws IOException {

        Ca ca = this.caService.getCaById(caId);
        String fileName= this.fileService.uploadImage(path, image);

        ca.setImageCa(fileName);
        Ca updated = this.caService.editItem(ca, caId);
        return new ResponseEntity<Ca>(updated, HttpStatus.OK);
    }

    //method to serve file
    @GetMapping(value = "/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {
        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }
}
