/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.testallservicesforvcs.adventureworks2014.EmployeeDepartmentHistory;
import com.testallservicesforvcs.adventureworks2014.EmployeeDepartmentHistoryId;
import com.testallservicesforvcs.adventureworks2014.service.EmployeeDepartmentHistoryService;

/**
 * Controller object for domain model class EmployeeDepartmentHistory.
 * @see EmployeeDepartmentHistory
 */
@RestController("AdventureWorks2014.EmployeeDepartmentHistoryController")
@Api(value = "EmployeeDepartmentHistoryController", description = "Exposes APIs to work with EmployeeDepartmentHistory resource.")
@RequestMapping("/AdventureWorks2014/EmployeeDepartmentHistory")
public class EmployeeDepartmentHistoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDepartmentHistoryController.class);

    @Autowired
    @Qualifier("AdventureWorks2014.EmployeeDepartmentHistoryService")
    private EmployeeDepartmentHistoryService employeeDepartmentHistoryService;

    @ApiOperation(value = "Creates a new EmployeeDepartmentHistory instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EmployeeDepartmentHistory createEmployeeDepartmentHistory(@RequestBody EmployeeDepartmentHistory employeeDepartmentHistory) {
        LOGGER.debug("Create EmployeeDepartmentHistory with information: {}", employeeDepartmentHistory);
        employeeDepartmentHistory = employeeDepartmentHistoryService.create(employeeDepartmentHistory);
        LOGGER.debug("Created EmployeeDepartmentHistory with information: {}", employeeDepartmentHistory);
        return employeeDepartmentHistory;
    }

    @ApiOperation(value = "Returns the EmployeeDepartmentHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EmployeeDepartmentHistory getEmployeeDepartmentHistory(@RequestParam(value = "businessEntityId", required = true) Integer businessEntityId, @RequestParam(value = "startDate", required = true) Date startDate, @RequestParam(value = "departmentId", required = true) Short departmentId, @RequestParam(value = "shiftId", required = true) Short shiftId) throws EntityNotFoundException {
        EmployeeDepartmentHistoryId employeedepartmenthistoryId = new EmployeeDepartmentHistoryId();
        employeedepartmenthistoryId.setBusinessEntityId(businessEntityId);
        employeedepartmenthistoryId.setStartDate(startDate);
        employeedepartmenthistoryId.setDepartmentId(departmentId);
        employeedepartmenthistoryId.setShiftId(shiftId);
        LOGGER.debug("Getting EmployeeDepartmentHistory with id: {}", employeedepartmenthistoryId);
        EmployeeDepartmentHistory employeeDepartmentHistory = employeeDepartmentHistoryService.getById(employeedepartmenthistoryId);
        LOGGER.debug("EmployeeDepartmentHistory details with id: {}", employeeDepartmentHistory);
        return employeeDepartmentHistory;
    }

    @ApiOperation(value = "Updates the EmployeeDepartmentHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EmployeeDepartmentHistory editEmployeeDepartmentHistory(@RequestParam(value = "businessEntityId", required = true) Integer businessEntityId, @RequestParam(value = "startDate", required = true) Date startDate, @RequestParam(value = "departmentId", required = true) Short departmentId, @RequestParam(value = "shiftId", required = true) Short shiftId, @RequestBody EmployeeDepartmentHistory employeeDepartmentHistory) throws EntityNotFoundException {
        employeeDepartmentHistory.setBusinessEntityId(businessEntityId);
        employeeDepartmentHistory.setStartDate(startDate);
        employeeDepartmentHistory.setDepartmentId(departmentId);
        employeeDepartmentHistory.setShiftId(shiftId);
        LOGGER.debug("EmployeeDepartmentHistory details with id is updated with: {}", employeeDepartmentHistory);
        return employeeDepartmentHistoryService.update(employeeDepartmentHistory);
    }

    @ApiOperation(value = "Deletes the EmployeeDepartmentHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteEmployeeDepartmentHistory(@RequestParam(value = "businessEntityId", required = true) Integer businessEntityId, @RequestParam(value = "startDate", required = true) Date startDate, @RequestParam(value = "departmentId", required = true) Short departmentId, @RequestParam(value = "shiftId", required = true) Short shiftId) throws EntityNotFoundException {
        EmployeeDepartmentHistoryId employeedepartmenthistoryId = new EmployeeDepartmentHistoryId();
        employeedepartmenthistoryId.setBusinessEntityId(businessEntityId);
        employeedepartmenthistoryId.setStartDate(startDate);
        employeedepartmenthistoryId.setDepartmentId(departmentId);
        employeedepartmenthistoryId.setShiftId(shiftId);
        LOGGER.debug("Deleting EmployeeDepartmentHistory with id: {}", employeedepartmenthistoryId);
        EmployeeDepartmentHistory employeeDepartmentHistory = employeeDepartmentHistoryService.delete(employeedepartmenthistoryId);
        return employeeDepartmentHistory != null;
    }

    /**
     * @deprecated Use {@link #findEmployeeDepartmentHistories(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of EmployeeDepartmentHistory instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EmployeeDepartmentHistory> searchEmployeeDepartmentHistoriesByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering EmployeeDepartmentHistories list");
        return employeeDepartmentHistoryService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of EmployeeDepartmentHistory instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EmployeeDepartmentHistory> findEmployeeDepartmentHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeDepartmentHistories list");
        return employeeDepartmentHistoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of EmployeeDepartmentHistory instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/filter", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EmployeeDepartmentHistory> filterEmployeeDepartmentHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeDepartmentHistories list");
        return employeeDepartmentHistoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEmployeeDepartmentHistories(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return employeeDepartmentHistoryService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of EmployeeDepartmentHistory instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countEmployeeDepartmentHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting EmployeeDepartmentHistories");
        return employeeDepartmentHistoryService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeDepartmentHistoryService instance
	 */
    protected void setEmployeeDepartmentHistoryService(EmployeeDepartmentHistoryService service) {
        this.employeeDepartmentHistoryService = service;
    }
}
