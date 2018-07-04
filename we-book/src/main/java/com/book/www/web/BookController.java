package com.book.www.web;

import com.book.www.service.BookService;
import com.iweb.context.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BookController {

    private static final int NODE_PAGE_SIZE=150;
    private static final int BOOK_PAGE_SIZE=50;
    private static final int DEFAULT_CURRENT_PAGE=1;

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    public Object details(@PathVariable("bookId")int bookId,Model model){
        model.addAttribute("book",bookService.get(bookId));
        return "bookindex";
    }

    @GetMapping("/book/list")
    public Object list(Model model){
        model.addAttribute("page",bookService.list(new Page(DEFAULT_CURRENT_PAGE,BOOK_PAGE_SIZE)));
        return "booklist";
    }

    @GetMapping("/book/list/p{currentPage}")
    public Object list(@PathVariable("currentPage")int currentPage,Model model){
        model.addAttribute("page",bookService.list(new Page(currentPage,BOOK_PAGE_SIZE)));
        return "booklist";
    }

    @GetMapping("/node/{bookId}")
    public Object nodeList(@PathVariable("bookId")int bookId,Model model){
        model.addAttribute("page",bookService.nodeList(bookId,new Page(DEFAULT_CURRENT_PAGE,NODE_PAGE_SIZE)));
        model.addAttribute("book",bookService.get(bookId));
        return "nodelist";
    }

    @GetMapping("/node/{bookId}/p{currentPage}")
    public Object nodeList(@PathVariable("bookId")int bookId,@PathVariable("currentPage")int currentPage,Model model){
        model.addAttribute("page",bookService.nodeList(bookId,new Page(currentPage,NODE_PAGE_SIZE)));
        model.addAttribute("book", bookService.get(bookId));
        return "nodelist";
    }

    @GetMapping("/node/{bookId}/{nodeId}")
    public Object content(@PathVariable("bookId")int bookId,@PathVariable("nodeId")int nodeId,Model model){
        model.addAttribute("node",bookService.content(nodeId));
        model.addAttribute("book",bookService.get(bookId));
        return "content";
    }
}
