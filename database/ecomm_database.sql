USE [Ecommerce]
GO
/****** Object:  Table [dbo].[category_menu]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[category_menu](
	[id] [int] NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](150) NULL,
	[order_section] [int] NOT NULL,
	[role_id] [int] NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[flash_sale]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[flash_sale](
	[id] [varchar](36) NOT NULL,
	[promo_id] [varchar](36) NULL,
	[product_id] [varchar](36) NULL,
	[name] [varchar](100) NULL,
	[description] [varchar](150) NULL,
	[quantity] [int] NOT NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[is_active] [int] NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[news]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[news](
	[id] [varchar](36) NOT NULL,
	[title] [varchar](100) NOT NULL,
	[body] [text] NOT NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[is_active] [int] NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[orders]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orders](
	[id] [varchar](36) NOT NULL,
	[user_id] [varchar](36) NULL,
	[product_id] [varchar](36) NULL,
	[promo_id] [varchar](36) NULL,
	[flash_sale_id] [varchar](36) NULL,
	[quantity] [int] NOT NULL,
	[total_price] [float] NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[products]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[products](
	[id] [varchar](36) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[type] [varchar](50) NOT NULL,
	[description] [varchar](150) NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[is_active] [int] NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[promo]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[promo](
	[id] [varchar](36) NOT NULL,
	[user_id] [varchar](36) NULL,
	[order_id] [varchar](36) NULL,
	[status] [varchar](20) NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[transaction_history]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[transaction_history](
	[id] [int] NOT NULL,
	[role_name] [varchar](50) NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_role]    Script Date: 14/09/2019 11:43:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_role](
	[id] [varchar](36) NOT NULL,
	[role_id] [int] NULL,
	[name] [varchar](100) NULL,
	[email] [varchar](150) NOT NULL,
	[address] [varchar](150) NULL,
	[is_male] [int] NULL,
	[username] [varchar](100) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
