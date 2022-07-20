package com.it.academy.maintenancestation.restController;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Administrator RestController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@RestController
@RequestMapping("/administratorRest")
@RequiredArgsConstructor
public class AdministratorRestController {

    /**
     *
     */
    private final AdministratorService administratorService;

    /**
     * @return List<AdministratorDto>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdministratorDto> listAdministrators() {
        return administratorService.listAllAdministrators();
    }

    /**
     * @param administratorId
     * @return AdministratorDto administratorDto
     */
    @GetMapping(value = "/{administratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdministratorDto getAdministrator(@PathVariable("administratorId") Integer administratorId) {
        return administratorService.findAdministratorById(administratorId);
    }

    /**
     * @param administratorId
     * @return
     */
    @GetMapping("/deleteAdministrator/{administratorId}")
    private String deleteAdministrator(@PathVariable("administratorId") Integer administratorId) {
        administratorService.deleteAdministratorById(administratorId);
        return "Deleted!";
    }

//    /**
//     * @param administratorDto
//     * @return
//     */
//    @PostMapping("/saveAdministrator")
//    private AdministratorDto saveAdministrator(@RequestBody AdministratorDto administratorDto) {
//   administratorService.addAdministrator(administratorDto);
//        return getAdministrator(administratorDto.getAdministratorId());
//    }
//
//    /**
//     * @param administratorDto
//     * @return
//     */
//    @PostMapping("/editAdministrator/{administratorId}")
//    private void editAdministrator(@RequestBody AdministratorDto administratorDto,
//                                               @PathVariable("administratorId") Integer administratorId) {
//        AdministratorDto administratorDto1 = administratorService.findAdministratorById(administratorId);
//        administratorDto1.setAdministratorName(administratorDto.getAdministratorName());
//        administratorDto1.setAdministratorLastName(administratorDto.getAdministratorLastName());
//        administratorService.addAdministrator(administratorDto1);
//    }
}


