package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

        @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments",method = RequestMethod.POST) // @RequestBody String commentText
        public String createImageComment(@PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String title,@RequestParam("comment") String commentText,HttpSession session){
         Image image = imageService.getImageByTitle(title,imageId);
         User user = (User)session.getAttribute("loggeduser");

        Comments newComment;
        newComment = new Comments();

        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setText(commentText);

        commentService.createImageComment(newComment);

        return "redirect:/images/"+image.getId()+"/"+ image.getTitle();




    }

}
