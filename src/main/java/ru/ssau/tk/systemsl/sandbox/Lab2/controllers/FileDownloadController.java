package ru.ssau.tk.systemsl.sandbox.Lab2.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.util.ResourceUtils.getFile;

@Controller
@RequestMapping("/WebOutput")
public class FileDownloadController {
    private static final String FILE_PATH_1 = "src/main/resources/static/WebOutput/tabfunc_1.bin";
    private static final String FILE_PATH_2 = "src/main/resources/static/WebOutput/tabfunc_2.bin";
    private static final String FILE_PATH_RESULT = "src/main/resources/static/WebOutput/tabfunc_result.bin";
    private static final String FILE_PATH_TABLE = "src/main/resources/static/WebOutput/tabfunc_table.bin";
    private static final String FILE_PATH_FUNCTION = "src/main/resources/static/WebOutput/tabfunc_function.bin";
    private static final String FILE_PATH_3 = "src/main/resources/static/WebOutput/tabfunc_3.bin";
    private static final String FILE_PATH_DIFFERENTIAL = "src/main/resources/static/WebOutput/tabfunc_differ.bin";
    private static final String APPLICATION_BIN = "application/bin";

    @RequestMapping(value = "/tabfunc_1", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void download1(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_1);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
    @RequestMapping(value = "/tabfunc_2", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void download2(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_2);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
    @RequestMapping(value = "/tabfunc_result", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void downloadRESULT(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_RESULT);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
    @RequestMapping(value = "/tabfunc_table", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void downloadTABLE(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_TABLE);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
    @RequestMapping(value = "/tabfunc_function", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void downloadFUNCTION(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_FUNCTION);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping(value = "/tabfunc_3", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void download3(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_3);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping(value = "/tabfunc_differ", method = RequestMethod.GET, produces = APPLICATION_BIN)
    public @ResponseBody void downloadDIFFER(HttpServletResponse response) throws IOException {
        File file = getFile(FILE_PATH_DIFFERENTIAL);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_BIN);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
}

