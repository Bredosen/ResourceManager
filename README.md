# Welcome To ResourceManager
ResourceManager serves as a sophisticated API tailored for the SpigotMC Minecraft server environment. It provides developers with an intuitive interface, allowing for the seamless creation and management of resources or files within a Minecraft server. These resources are designed for effortless access and manipulation, anchored by a globally accessible point for their adjustment. This feature empowers developers with unparalleled control, enabling them to craft and oversee resources throughout their projects according to their preferences.

At the heart of ResourceManager is a prebuilt Resource entity, engineered to encapsulate custom data. This data can be diversified into types, values, comments, and unique configurations, enriching the resource's versatility. When custom serialization is in place, these configurations unlock new potentials, allowing for tailored data handling. By default, ResourceManager employs a JSON/YAML Jsoup serialization method, but it also offers the flexibility for developers to institute their own serialization schemes for enhanced customization.

## Create a resource
To illustrate the practicality and ease of use provided by ResourceManager, consider the following example, which outlines the steps to create a simple resource and imbue it with default values:

  

    public final class Example extends JavaPlugin {  
      
	      @Override  
	      public void onLoad() {  
                    // Initialize a new resource instance identified by the name "config".  
		    // This step is crucial for setting up the configuration resource before the plugin is fully enabled.
		    ResourceCreator.create("config");  
      
                    // Configure the "config" resource with specific file attributes.  
		    // Parameters: 
		    //  - "Config": The file name. This determines the name of the file as it will appear on the filesystem. 
		    //  - "": The directory path. An empty string indicates that the file will be located in the root of the specified location (plugin folder if the 5th parameter is true). 
		    //  - "yml": The file extension. This specifies the type of file to be created, in this case, a YAML file. 
		    //  - true: The "usePluginFolder" flag. When set to true, it indicates that the file should be located within the plugin's directory. 
		    // This command initializes the "config" resource file with the name "Config.yml" directly inside the plugin's folder, ensuring it's ready for use. 	
		    FileContextManipulator.setFile("config", "Config", "", "yml", true);  
      
                    // Assign default settings to the "config" resource using a custom defaults setter.  
		    // This step is essential for ensuring that the "config" resource has a predefined set of values, 
		    // which can later be customized or extended by the plugin or its users. 
		    ResourceManipulator.setIDefaultsSetter("config", configDefaultsSetter);  
	      }  
      
	      @Override  
	      public void onEnable() {  
                    // Load the "config" resource, applying default values before attempting to read existing configuration from the file.  
		    // This ensures that any missing settings are initialized with default values, providing a complete configuration set.
		    ResourceState.load("config", true);  
      
                    // Persist the current state of the "config" resource to its corresponding file.  
		    // This operation is crucial for saving any changes made to the configuration during the plugin's runtime,
		    // ensuring that they are retained across server restarts or plugin reloads. 
		    ResourceState.save("config");  
	      }  
      
            // Define a custom IDefaultsSetter implementation for the "config" resource.  
	    // This interface's implementation is responsible for specifying the default data structure and values for the resource.
	    // It is invoked whenever default values need to be loaded into the resource, such as during initialization or when resetting configurations.
	    // The provided example sets up a simple message-of-the-day (MOTD) configuration.
	    public final IDefaultsSetter configDefaultsSetter = dataRegistry -> {  
	            // Create a new configuration element for the message of the day with a default welcome message.  
		    // This element is a part of the "config" resource and can be used to display a custom message to users upon joining the server.
		    final JsonData messageOfTheDay = new JsonData("motd");  
                    messageOfTheDay.setValue("Welcome to the server!");  
      
                    // Add a descriptive comment to the MOTD configuration element, explaining its purpose.  
		    // This comment can assist administrators in understanding the role of this configuration option within the file.
		    messageOfTheDay.addComment("This is the configuration for the server's Message of the Day (MOTD).");  
      
                    // Register the MOTD element with the data registry to include it in the "config" resource.  
		    // This step integrates the element into the resource, making it an official part of the configuration structure.
		    dataRegistry.registerElement(messageOfTheDay);  
            };  
    }

This example would typically demonstrate the straightforward process of initializing a resource, setting its default parameters, and integrating it within a project, showcasing ResourceManager's capability to streamline and enhance the development experience on SpigotMC servers.

## Get and set data
This example elucidates the method of retrieving and modifying data within a resource, illustrating the dynamic interaction capabilities that ResourceManager offers to developers. Through this demonstration, one can appreciate the API's flexibility and ease of use in data management tasks.

    // Retrieve data from a resource.  
    final String motd = DataAccessor.getString("config", "motd");  
      
    // Set data to a resource.  
    DataAccessor.set("config", "motd", "This is the new message of the day");

This example would likely detail the steps involved in accessing a specific resource, highlighting the API's straightforward commands for fetching data. Following this, it would showcase how to update or alter this data, reflecting changes that might be necessary as the project evolves. The process is designed to be intuitive, ensuring that developers can quickly adapt resources to meet the changing needs of their server environment.

By walking through this example, developers gain insight into the practical application of ResourceManager's functions, reinforcing the API's value in facilitating efficient and effective resource management within the Minecraft server landscape.
